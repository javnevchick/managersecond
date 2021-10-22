package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Application;
import com.fakhritdinov.managersecond.model.Client;
import com.fakhritdinov.managersecond.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;
    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/applications")
    public String applicationList(Model model) {
        List<Application> applications = applicationService.findAll();
        model.addAttribute("applications", applications);
        return "application-list";
    }


    @GetMapping("/application-result/")
    public String createClientForm(Model model) {
        Application applicate = applicationService.findLast();
        model.addAttribute("applicate", applicate);
        return "application-result";
    }

    /* Пробовал и таким образом (ниже), но выдает ту же ошибку. Возможно, проблема в связке с фронтом

    @GetMapping("/application-result")
    public String createClientForm(Model model) {
        model.addAttribute("applicate", new Application("imya", "gfd", "gvsg",
                "gedswe", "thgfd", "thefdh", 44));
        return "application-result";
    }*/

}
