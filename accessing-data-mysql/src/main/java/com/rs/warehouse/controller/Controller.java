package com.rs.warehouse.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.warehouse.DTO.Order;
import com.rs.warehouse.domain.Release;
import com.rs.warehouse.services.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("warehouse/api/v1")
public class Controller {

    @Autowired
    ReleaseService serviceInterface;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/create")
   public Release save(@RequestBody Release release) {
     //   System.out.println(release.getReleaseLine().size());
        return serviceInterface.save(release);
    }

   @GetMapping("/get/{id}")
    Optional<Release> getById(@PathVariable("id") Long id) {
        return serviceInterface.getById(id);
    }

    @PutMapping("/update/{id}")
    public Release putById(@PathVariable Long id, @RequestBody Release release) {


        return serviceInterface.putById(id,release);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id)
    {
         serviceInterface.delete(id);
    }

    @GetMapping("/getbyrelease/{id}")
    public Optional<Release> FindReleaseByReleaseId(@PathVariable("id") String id)
    {
        return serviceInterface.FindReleaseIdById(id);
    }


}
