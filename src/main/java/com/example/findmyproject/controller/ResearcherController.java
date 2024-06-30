package com.example.findmyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.findmyproject.model.*;
import com.example.findmyproject.service.*;
import java.util.*;

@RestController
public class ResearcherController {

    @Autowired
    private ResearcherJpaService rjs;

    @GetMapping("/researchers")
    public ArrayList<Researcher> getResearcher() {
        return rjs.getResearcher();
    }

    @GetMapping("/researchers/{researcherId}")
    public Researcher getResearcherById(@PathVariable("researcherId") int researcherId) {
        return rjs.getResearcherById(researcherId);
    }

    @PostMapping("/researchers")
    public Researcher addResearcher(@RequestBody Researcher researcher) {
        return rjs.addResearcher(researcher);
    }

    @PutMapping("/researchers/{researcherId}")
    public Researcher updateResearcher(@PathVariable("researcherId") int researcherId,
            @RequestBody Researcher researcher) {
        return rjs.updateResearcher(researcherId, researcher);
    }

    @DeleteMapping("/researchers/{researcherId}")
    public void deleteResearcher(@PathVariable("researcherId") int researcherId) {
        rjs.deleteResearcher(researcherId);
    }

    @GetMapping("/researchers/{researcherId}/projects")
    public List<Project> getResearcherProject(@PathVariable("researcherId") int researcherId) {
        return rjs.getResearcherProject(researcherId);
    }
}