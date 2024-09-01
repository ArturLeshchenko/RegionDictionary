package com.art.service;

import com.art.dao.RegionDao;
import com.art.entity.Region;
import com.art.exception.RegionNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionDao regionDao;
    public RegionServiceImpl(@Qualifier("regionDaoJPA") RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public Region findByRegionCode(int regionCode) {
        return regionDao.findByRegionCode(regionCode).orElseThrow(RegionNotFoundException::new);
    }

    @Override
    public void save(Region region) {
        regionDao.save(region);
    }

    @Override
    public void update(int regionCode, String regionName) {
        regionDao.update(regionCode, regionName);
    }

    @Override
    public void delete(int regionCode) {
        regionDao.delete(regionCode);
    }
}
