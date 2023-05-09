package com.agilecode.service;

import com.agilecode.entity.Application;
import com.agilecode.exception.ApplicationNotFoundException;
import com.agilecode.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookApplicationService implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if (optionalApplication.isPresent())
            return optionalApplication.get();
        else
            throw new ApplicationNotFoundException("Application Not Found");
    }


}