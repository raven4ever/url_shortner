package com.arp.shorturl.backend.data;

import com.arp.shorturl.backend.data.entities.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitialDataService {

    @Autowired
    private ShortUrlGenerator shortUrlGenerator;
    List<Mapping> toReturn = new ArrayList<>();

    public List<Mapping> getAll() {
        Mapping m1 = new Mapping("link1", shortUrlGenerator.generateShortUrl());
        Mapping m2 = new Mapping("link2", shortUrlGenerator.generateShortUrl());

        toReturn.add(m1);
        toReturn.add(m2);

        return toReturn;
    }

    public void addNewMapping(String longUrl) {
        toReturn.add(new Mapping(longUrl, shortUrlGenerator.generateShortUrl()));
    }
}
