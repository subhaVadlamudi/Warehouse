package com.rs.warehouse.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.warehouse.DTO.Order;
import com.rs.warehouse.DTO.OrderLine;
import com.rs.warehouse.DTO.SupplyData;
import com.rs.warehouse.assembler.OrderAssembler;
import com.rs.warehouse.assembler.SupplyDataAssembler;
import com.rs.warehouse.client.OrderClient;
import com.rs.warehouse.client.SupplyDataClient;
import com.rs.warehouse.domain.ReleaseLine;
import com.rs.warehouse.repository.ReleaseRepository;
import com.rs.warehouse.domain.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseRepository repository;
    OrderAssembler orderAssembler;
    SupplyDataAssembler supplyDataAssembler;
    OrderClient orderClient;
    SupplyDataClient supplyDataClient;

    @Override
    public Release save(Release release) {

        if (release.getStatus() == "Allocated") {
            release.setStatus("Released");
            Set<ReleaseLine> releaseLines = new HashSet<>();
            for (ReleaseLine releaseLine : release.getReleaseLine()) {
                releaseLine.setStatus("Released");
                releaseLines.add(releaseLine);
            }
            release.setReleaseLine(releaseLines);

            release.setReleaseLine(release.setChildren(release.getReleaseLine()));

            Release release1 = repository.save(release);

            Order order=orderAssembler.releaseToOrder(release);

            orderClient.orderUpdate(order);
            return release1;
        }
        return save(release);
    }

    @Override
    public Optional<Release> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<Release> FindReleaseIdById(String id) {
        return repository.findReleaseByReleaseId(id);
    }

    @Override
    public Release putById(Long id, Release release) {

        release.setStatus("Shipped");

        Set<ReleaseLine> releaseLines = new HashSet<>();
        for (ReleaseLine releaseLine : release.getReleaseLine()) {
            releaseLine.setStatus("Shipped");
            releaseLines.add(releaseLine);
        }
        release.setReleaseLine(releaseLines);
        if (repository.existsById(id)) {
            Order order=orderAssembler.releaseToOrder(release);
            orderClient.orderUpdate(order);
            Release release1 = repository.save(release);

            if (release.getStatus().equals("Shipped")) {
               SupplyData supplyData= supplyDataAssembler.releaseToSupplyData(release);
                supplyDataClient.supplyDataUpdate(supplyData);
                return release1;
            }

        }
        return null;
    }
}



//    @Override
//    public void deleteById(Long id) {
//        return repository.deleteById(id);
//    }

