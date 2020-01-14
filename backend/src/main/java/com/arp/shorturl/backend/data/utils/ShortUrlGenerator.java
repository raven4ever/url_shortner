package com.arp.shorturl.backend.data.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlGenerator {

    @Value("${app.shorturl.numberofcharacters}")
    private int targetNumberOfCharacters;

    public String generateShortUrl() {
        return RandomStringUtils.randomAlphanumeric(targetNumberOfCharacters);
    }
}
