package com.fakhritdinov.managersecond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstpageController {

    @GetMapping("/first-page")
    public String greeting() {
        return "first-page";
    }

}
