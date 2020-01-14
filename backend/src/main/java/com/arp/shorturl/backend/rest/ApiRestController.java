package com.arp.shorturl.backend.rest;

import com.arp.shorturl.backend.data.InitialDataService;
import com.arp.shorturl.backend.data.entities.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiRestController {

    @Autowired
    private InitialDataService initialDataService;

    @GetMapping("/all")
    public List<Mapping> getAllMappings() {
        return initialDataService.getAll();
    }

    @PostMapping(path = "/add", consumes = "text/plain", produces = "text/plain")
    public String addNewMapping(@RequestBody String longUrl) {
        return initialDataService.addNewMapping(longUrl);
    }
}
