package com.art.dao;

import com.art.entity.Region;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface RegionDao {
    List<Region> findAll();

    Optional<Region> findByRegionCode(int regionCode) ;

    void save(Region region);

    void update(int regionCode, String regionName) ;

    void delete(int regionCode) ;

}
