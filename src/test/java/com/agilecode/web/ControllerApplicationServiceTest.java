package com.agilecode.web;

import com.agilecode.entity.Application;
import com.agilecode.repository.ApplicationRepository;
import com.agilecode.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerApplicationServiceTest {
    @Autowired
    private ControllerApplicationService ControllerApplicationService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Mock
    private Model model;

    @Test
    public void contextLoads() throws Exception {
        assertThat(ControllerApplicationService).isNotNull();
    }

    @Test
    public void retrieveApplications() throws Exception {
        String returnValue = ControllerApplicationService.retrieveApplications(model);
        assertEquals("applications", returnValue);
    }

    @Test
    public void retrieveApplicationsFromService() throws Exception {
        Iterable<Application> applications = applicationService.listApplications();

        assertNotNull(applications);
        assertEquals(0, StreamSupport.stream(applications.spliterator(), false).count());
    }

    @Test
    public void retrieveApplicationsFromRepo() throws Exception {
        Iterable<Application> applications = applicationRepository.findAll();

        assertNotNull(applications);
        assertEquals(0, StreamSupport.stream(applications.spliterator(), false).count());
    }
}