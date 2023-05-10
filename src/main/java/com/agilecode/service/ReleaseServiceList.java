package com.agilecode.service;

import com.agilecode.entity.Release;
import com.agilecode.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceList implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;
    @Override
    public Iterable<Release> listReleases() {return releaseRepository.findAll();}
}
