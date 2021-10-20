package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Application;
import com.fakhritdinov.managersecond.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/applications")
    public String applicationList(Model model) {
        List<Application> applications = applicationService.findAll();
        model.addAttribute("applications", applications);
        return "application-list";
    }

    @PostMapping("@/application-result")
    public String applicationResult(Model model) {
        List<Application> applications = applicationService.findAll();
        Application application = applicationService.findById(applications.size() - 1);
        model.addAttribute("application", application);
        return "application-result";
    }
}
