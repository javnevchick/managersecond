package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FirstpageController {

    @GetMapping
    public String greeting() {
        return "index";
    }

    @GetMapping("/search-client")
    public String searchClient(Client client, Model model) {
        model.addAttribute("client", client);
        return "index";
    }


}
