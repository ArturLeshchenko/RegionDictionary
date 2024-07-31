package com.art.dao;

import com.art.entity.Region;

import java.util.List;

public interface RegionDao {
    List<Region> findAll() throws Exception;

    Region findByRegionCode(int regionCode);

    void save(Region region);

    void update(int regionCode, String regionName);

    void delete(int regionCode);

}
