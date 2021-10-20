package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Client;
import com.fakhritdinov.managersecond.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public String clientList(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client-list";
    }
}
