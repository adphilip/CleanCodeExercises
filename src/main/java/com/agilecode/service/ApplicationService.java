package com.agilecode.service;

import com.agilecode.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();

	Application findApplication(long id);
}
