package com.agilecode.service;

import com.agilecode.entity.Release;
import com.agilecode.repository.ReleaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ListReleaseService implements ReleaseService {
    private final ReleaseRepository releaseRepository;

    public ListReleaseService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    public Iterable<Release> listReleases() {
        return releaseRepository.findAll();
    }
}
