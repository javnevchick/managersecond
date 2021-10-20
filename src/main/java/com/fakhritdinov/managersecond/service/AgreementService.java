package com.fakhritdinov.managersecond.service;

import com.fakhritdinov.managersecond.model.Agreement;
import com.fakhritdinov.managersecond.repositiry.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgreementService {
    private final AgreementRepository agreementRepository;
    @Autowired
    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    public Agreement findById(Integer id) {
        return agreementRepository.getById(id);
    }

    public List<Agreement> findAll() {
        return agreementRepository.findAll();
    }
}
