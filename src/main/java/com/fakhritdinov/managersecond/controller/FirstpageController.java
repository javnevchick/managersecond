package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Client;
import com.fakhritdinov.managersecond.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstpageController {

    private final ClientService clientService;

    @Autowired
    public FirstpageController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String greeting() {
        return "index";
    }

    @GetMapping("/search-client")
    public String searchClient(
            @RequestParam(value = "contacte") String contacte,
            @RequestParam(value = "fielde") String fielde,
            Model model)
    {
        if(contacte.equals("fio")) {
            Client client = clientService.findByName(fielde);
            model.addAttribute("client", client);
        } else if(contacte.equals("passport")) {
            Client client = clientService.findByPassport(fielde);
            model.addAttribute("client", client);
        } else if (contacte.equals("contactNumber")) {
            Client client = clientService.findByContactNumber(fielde);
            model.addAttribute("client", client);
        }

        return "index";
    }


}
