package com.rs.warehouse.services;

import com.rs.warehouse.domain.Release;

import java.util.Optional;

public interface ReleaseService {

    Release save(Release release);

    Optional<Release> getById(Long id);

    void delete(Long id);

    Optional<Release> FindReleaseIdById(String id);

    Release putById(Long id, Release release);


}
