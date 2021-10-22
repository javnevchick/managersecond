package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Application;
import com.fakhritdinov.managersecond.model.Client;
import com.fakhritdinov.managersecond.service.AgreementService;
import com.fakhritdinov.managersecond.service.ApplicationService;
import com.fakhritdinov.managersecond.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateApplicationController {
    private final ClientService clientService;
    private final ApplicationService applicationService;
    @Autowired
    public CreateApplicationController(ApplicationService applicationService, ClientService clientService) {
        this.applicationService = applicationService;
        this.clientService = clientService;
    }


    @GetMapping("/create-application")
    public String createClientForm(Client client, Model model) {
        model.addAttribute("client", client);
        return "create-application";
    }

    @PostMapping("/create-client-and-application")
    public String createClient(Client client) {
        clientService.saveClient(client);
        applicationService.saveApplicationByClient(client);
        return "application-result";
    }

}
