package com.arp.shorturl.backend.data;

import com.arp.shorturl.backend.data.entities.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitialDataService {

    private List<Mapping> toReturn = new ArrayList<>();
    @Autowired
    private ShortUrlGenerator shortUrlGenerator;

    @PostConstruct
    public void init() {
        Mapping m1 = new Mapping("link1", shortUrlGenerator.generateShortUrl());
        Mapping m2 = new Mapping("link2", shortUrlGenerator.generateShortUrl());

        toReturn.add(m1);
        toReturn.add(m2);
    }

    public List<Mapping> getAll() {
        return toReturn;
    }

    public String addNewMapping(String longUrl) {
        String generatedValue = shortUrlGenerator.generateShortUrl();
        toReturn.add(new Mapping(longUrl, generatedValue));

        return generatedValue;
    }
}
