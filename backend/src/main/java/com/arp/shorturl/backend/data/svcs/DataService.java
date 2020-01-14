package com.arp.shorturl.backend.data.svcs;

import com.arp.shorturl.backend.data.model.Mapping;
import com.arp.shorturl.backend.data.repos.MappingRepository;
import com.arp.shorturl.backend.data.utils.ShortUrlGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class DataService {

    @Autowired
    private ShortUrlGenerator shortUrlGenerator;
    @Autowired
    private MappingRepository mappingRepository;
    @Value("${app.entry.ttl}")
    private Long entryTtl;

    @PostConstruct
    public void init() {
        log.info("ttl->" + entryTtl);

        Mapping m1 = new Mapping(shortUrlGenerator.generateShortUrl(), "link1", entryTtl);
        Mapping m2 = new Mapping(shortUrlGenerator.generateShortUrl(), "link2", entryTtl);

        mappingRepository.save(m1);
        mappingRepository.save(m2);
    }

    public List<Mapping> getAll() {
        return IterableUtils.toList(mappingRepository.findAll());
    }

    public String addNewMapping(String longUrl) {
        String generatedValue = shortUrlGenerator.generateShortUrl();

        mappingRepository.save(new Mapping(generatedValue, longUrl, entryTtl));

        log.info("saved->" + generatedValue);

        return generatedValue;
    }
}
