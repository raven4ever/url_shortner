package com.arp.shorturl.frontend.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestClientService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${app.backend.fullurl}")
    private String backendUrl;

    public void getNewMappingFor(String longUrl) {
        ResponseEntity<String> nmr = restTemplate.postForEntity(backendUrl + "/add", longUrl, String.class);

        log.info("generated url->" + nmr.getBody());
    }
}
