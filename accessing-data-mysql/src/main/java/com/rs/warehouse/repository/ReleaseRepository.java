package com.rs.warehouse.repository;

import com.rs.warehouse.domain.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {

   Optional<Release>  findReleaseByReleaseId (String id);



}
