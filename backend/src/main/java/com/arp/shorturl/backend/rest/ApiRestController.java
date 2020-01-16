package com.arp.shorturl.backend.rest;

import com.arp.shorturl.backend.data.model.Mapping;
import com.arp.shorturl.backend.data.svcs.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ApiRestController {

    @Autowired
    private DataService dataService;

    @GetMapping("/get/all")
    public List<Mapping> getAllMappings() {
        return dataService.getAll();
    }

    @GetMapping("/get/{existingMapping}")
    public String getExistingMapping(@PathVariable("existingMapping") String existingMapping) {
        return dataService.getExistingMapping(existingMapping);
    }

    @PostMapping(path = "/add", consumes = "text/plain", produces = "text/plain")
    public String addNewMapping(@RequestBody String longUrl) {
        log.info("processing for->" + longUrl);
        return dataService.addNewMapping(longUrl);
    }
}
