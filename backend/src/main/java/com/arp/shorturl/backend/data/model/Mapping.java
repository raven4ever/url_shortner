package com.arp.shorturl.backend.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RedisHash("mappings")
public class Mapping implements Serializable {

    @Id
    private String shortUrl;
    private String targetUrl;
    @TimeToLive(unit = TimeUnit.MINUTES)
    private Long ttl;

}
