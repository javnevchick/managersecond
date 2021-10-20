package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FirstpageController {

    @GetMapping
    public String greeting() {
        return "index";
    }

}
