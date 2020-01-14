package com.arp.shorturl.backend.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mapping {

    private String targetUrl;
    private String shortUrl;

}
