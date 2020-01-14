package com.arp.shorturl.backend.data.repos;

import com.arp.shorturl.backend.data.model.Mapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepository extends CrudRepository<Mapping, String> {
}
