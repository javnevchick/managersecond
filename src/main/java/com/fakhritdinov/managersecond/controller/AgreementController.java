package com.fakhritdinov.managersecond.controller;

import com.fakhritdinov.managersecond.model.Agreement;
import com.fakhritdinov.managersecond.service.AgreementService;
import com.fakhritdinov.managersecond.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AgreementController {
    private final AgreementService agreementService;
    private final ApplicationService applicationService;
    @Autowired
    public AgreementController(AgreementService agreementService, ApplicationService applicationService) {
        this.agreementService = agreementService;
        this.applicationService = applicationService;
    }


    @PostMapping("/agreements")
    public String agreementList(Model model) {
        List<Agreement> agreements = agreementService.findAll();
        model.addAttribute("agreements", agreements);
        return "agreement-list";
    }

    @GetMapping("/create-agreement")
    public String createAgreement(Model model) {

        Agreement agreement = new Agreement(applicationService.findLast());
        agreementService.saveAgreement(agreement);
        model.addAttribute("agreement", agreement);
        return "agreement";
    }

    @PostMapping("/get-sign/{id}")
    public String getSign(@PathVariable("id") Integer id, Model model) {
        Agreement agreement = agreementService.findById(id);
        agreement.setSign();
        agreementService.saveAgreement(agreement);
        return "/";
    }
}
