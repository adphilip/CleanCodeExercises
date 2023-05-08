package com.agilecode.service;

import java.util.List;
import java.util.Optional;

import com.agilecode.entity.Application;
import com.agilecode.exception.ApplicationNotFoundException;
import com.agilecode.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//TODO 3 - find a better name
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    // TODO 7 - Remove unused code
    // @Override
    // public Iterable<Application> listApplications() {
    //     return applicationRepository.findAll();
    // }

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent())
            return optionalApplication.get();
        else
            throw new ApplicationNotFoundException("Application Not Found");
    }


}
