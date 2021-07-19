package com.grtanner.logentry.controllers;

import com.grtanner.logentry.repositories.LogEntryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author glen on 07/14/2021
 */
@Controller
public class LogEntryController {

    private final LogEntryRepository logEntryRepository;

    public LogEntryController(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @RequestMapping("/apachelog")
    public String getLogEntries(Model model) {

        model.addAttribute("logEntries", logEntryRepository.findAll());
        return "apachelog/list";
    }
}
