package com.arp.shorturl.frontend.rest.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewMappingResponse {

    private String shortUrl;

}
