package com.arp.shorturl.backend.rest;

import com.arp.shorturl.backend.data.model.Mapping;
import com.arp.shorturl.backend.data.svcs.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
public class ApiRestController {

    @Autowired
    private DataService dataService;

    @GetMapping("/all")
    public List<Mapping> getAllMappings() {
        return dataService.getAll();
    }

    @PostMapping(path = "/add", consumes = "text/plain", produces = "text/plain")
    public String addNewMapping(@RequestBody String longUrl) {
        log.info("processing for->" + longUrl);
        return dataService.addNewMapping(longUrl);
    }

}
