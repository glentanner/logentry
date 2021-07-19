package com.grtanner.logentry.controllers;

import com.grtanner.logentry.repositories.LogEntryRepository;
import com.grtanner.logentry.repositories.SequenceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author glen on 07/14/2021
 */
@Controller
public class SequenceController {

    private final SequenceRepository sequenceRepository;

    public SequenceController(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    @RequestMapping("/apachelog/sequence")
    public String getSequences(Model model) {

        model.addAttribute("sequences", sequenceRepository.findAllSequences());
        return "apachelog/sequence";
    }
}
