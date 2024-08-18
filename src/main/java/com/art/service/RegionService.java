package com.art.service;

import com.art.entity.Region;

import java.sql.SQLException;
import java.util.List;

public interface RegionService {
    List<Region> findAll();

    Region findByRegionCode(int regionCode) ;

    void save(Region region);

    void update(int regionCode, String regionName);

    void delete(int regionCode);

}
