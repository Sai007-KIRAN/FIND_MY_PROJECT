package com.example.findmyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.findmyproject.model.*;
import com.example.findmyproject.service.*;
import java.util.*;

@RestController
public class ProjectController {

    @Autowired
    private ProjectJpaService pjs;

    @GetMapping("/researchers/projects")
    public ArrayList<Project> getProject() {
        return pjs.getProject();
    }

    @GetMapping("/researchers/projects/{projectId}")
    public Project getProjectById(@PathVariable("projectId") int projectId) {
        return pjs.getProjectById(projectId);
    }

    @PostMapping("/researchers/projects")
    public Project addProject(@RequestBody Project project) {
        return pjs.addProject(project);
    }

    @PutMapping("/researchers/projects/{projectId}")
    public Project updateProject(@PathVariable("projectId") int projectId, @RequestBody Project project) {
        return pjs.updateProject(projectId, project);
    }

    @DeleteMapping("/researchers/projects/{projectId}")
    public void deleteProject(@PathVariable("projectId") int projectId) {
        pjs.deleteProject(projectId);
    }

    @GetMapping("/projects/{projectId}/researchers")
    public List<Researcher> getProjectResearcher(@PathVariable("projectId") int projectId) {
        return pjs.getProjectResearcher(projectId);
    }
}