package com.arp.shorturl.backend.data;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlGenerator {
    private int targetNumberOfCharacters = 7;

    public String generateShortUrl() {
        return RandomStringUtils.randomAlphanumeric(targetNumberOfCharacters);
    }
}
