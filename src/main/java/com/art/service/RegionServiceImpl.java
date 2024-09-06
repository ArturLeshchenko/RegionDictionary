package com.art.service;

import com.art.entity.Region;
import com.art.exception.RegionAlreadyExistException;
import com.art.exception.RegionNotFoundException;
import com.art.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region findByRegionCode(int regionCode) {
        return regionRepository.findById(regionCode).orElseThrow(RegionNotFoundException::new);
    }

    @Override
    public void save(Region region) {
        boolean isExists = regionRepository.existsById(region.getRegionCode());
        if (isExists) {
            throw new RegionAlreadyExistException();
        }
        regionRepository.save(region);
    }

    @Override
    public void update(int regionCode, String regionName) {
        boolean isExists = regionRepository.existsById(regionCode);
        if (!isExists) {
            throw new RegionNotFoundException();
        }
        regionRepository.save(new Region(regionCode, regionName));
    }

    @Override
    public void delete(int regionCode) {
        regionRepository.deleteById(regionCode);
    }
}
