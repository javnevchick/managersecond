package com.fakhritdinov.managersecond.service;

import com.fakhritdinov.managersecond.model.Application;
import com.fakhritdinov.managersecond.repositiry.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application findById(Integer id) {
        return  applicationRepository.getById(id);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

}
