package com.fakhritdinov.managersecond.service;

import com.fakhritdinov.managersecond.model.Application;
import com.fakhritdinov.managersecond.model.Client;
import com.fakhritdinov.managersecond.repositiry.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    public Application saveApplicationByClient(Client client) {
        Application application = new Application(client);
        return applicationRepository.save(application);
    }

    public Application getLastApplication() {
        List<Application> applications = applicationRepository.findAll();
        return applications.get(applications.size() - 1);
    }
    // Эти два метода выполняют одно действие. Я попробовал разные реализации, чтобы справиться с ошибкой
    public Application findLast() {
        return applicationRepository.getLast();
    }

}
