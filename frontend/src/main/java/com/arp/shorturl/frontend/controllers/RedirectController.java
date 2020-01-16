package com.arp.shorturl.frontend.controllers;

import com.arp.shorturl.frontend.rest.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    @Autowired
    private RestClientService restClientService;

    @GetMapping("/{shortUrl}")
    public void redirectToMappedPage(@PathVariable("shortUrl") String shortUrl) {
        restClientService.getExistingMapping(shortUrl);
    }
}
