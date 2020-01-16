package com.arp.shorturl.frontend.controllers;

import com.arp.shorturl.frontend.rest.RestClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Slf4j
public class RedirectController {

    @Autowired
    private RestClientService restClientService;
    @Value("${app.nosuchelement.text}")
    private String noSuchElementString;

    @GetMapping("/{shortUrl}")
    public RedirectView redirectToMappedPage(@PathVariable("shortUrl") String shortUrl) {
        String result = restClientService.getExistingMapping(shortUrl);
        RedirectView redirectView = new RedirectView();

        log.info("received answer-> " + result);

        if (result.trim().equals(noSuchElementString)) {
            redirectView.setUrl("http://bing.com");
        } else {
            redirectView.setUrl("http://" + result);
        }

        return redirectView;
    }
}
