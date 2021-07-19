package com.grtanner.logentry.bootstrap;

import com.grtanner.logentry.domain.LogEntry;
import com.grtanner.logentry.repositories.LogEntryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author glen on 07/14/2021
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final LogEntryRepository logEntryRepository;

    public BootStrapData(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add the LogEntries to the LogEntryRepository
        for (LogEntry entry : getLogEntries() ) {
            this.logEntryRepository.save(entry);
        }
        System.out.println("There are " + logEntryRepository.count() + " entries");
    }

    private List<LogEntry> getLogEntries() throws MalformedURLException {
        // Store each line of the access log as a LogEntry in a list
        List<LogEntry> requestRecordList = new ArrayList<>();

        // Hard coded URL
        //URL url = new URL("https://files.inspiringapps.com/IAChallenge/30E02AAA-B947-4D4B-8FB6-9C57C43872A9/Apache.log");
        String regex = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"(.+?)\"";
        Pattern p = Pattern.compile(regex);

        for (String record : getAllLogEntriesAsList()) {
            Matcher matcher = p.matcher(record);
            if (matcher.find()) {
                // Split the request to get the endpoint
                String request = matcher.group(5);
                String[] splitRequest = request.split(" ");
                String endpoint = splitRequest[1];

                // Initially, mandatory fields are IP Address, Timestamp, and the endpoint split out from the request
                LogEntry entry =
                        new LogEntry.LogEntryBuilder(matcher.group(1), matcher.group(4), endpoint)
                                .build();
                requestRecordList.add(entry);
            }
        }
        return requestRecordList;
    }

    private List<String> getAllLogEntriesAsList() throws MalformedURLException {
        List<String> fullRequestList = new ArrayList<>();
        // Hard coded URL
        URL url = new URL("https://files.inspiringapps.com/IAChallenge/30E02AAA-B947-4D4B-8FB6-9C57C43872A9/Apache.log");

        try {
            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = in.readLine()) != null) {
                fullRequestList.add(line);
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return fullRequestList;
    }
}
