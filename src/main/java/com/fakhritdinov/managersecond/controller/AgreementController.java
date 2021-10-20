package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Agreement;
import com.fakhritdinov.managersecond.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AgreementController {
    private final AgreementService agreementService;

    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @PostMapping("/agreements")
    public String agreementList(Model model) {
        List<Agreement> agreements = agreementService.findAll();
        model.addAttribute("agreements", agreements);
        return "agreement-list";
    }
}
