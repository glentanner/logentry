# Log Entry

Log Entry is a simple Spring Boot application that allows us to query Apache Access Log files. This initial version has two defined endpoints. 

# Installation

Log entry can be accessed at: https://logentry.herokuapp.com/apachelog/sequence

## Source file 
The Apache Access log file is read from https://files.inspiringapps.com/IAChallenge/30E02AAA-B947-4D4B-8FB6-9C57C43872A9/Apache.log. The log elements are stored in an embedded H2 database for further query.

## Endpoints
The log is stored in a log_entry table with the fields: id, bytes_sent, ip_addr, referer, request, source, status_code, timestamp, user_agent, user_id, and username.

### /apachelog/
This "test" endpoint filters each Log Entry list as a source page, and the IP Address that accessed that page.

### /apachelog/sequence
This endpoint displays the Most Common Three Page Sequences Accessed by Users. We can create a sequence of pages accessed by sorting the log entries by timestamp and IP Address (unique user). For each source page accessed, we then determine the page accessed immediately before, and the page accessed immediately after, for each IP Address (unique user) using the SQL functions Concat, Lead, and Lag. From this result set, we simply count the number of these sequences accessed. The endpoint then displays this list as source, sequence, and count.

## Further Queries
This app can be expanded to find much more data from the log file, by defining SQL queries for new endpoints.

## License
[MIT](https://choosealicense.com/licenses/mit/)
