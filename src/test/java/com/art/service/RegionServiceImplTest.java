package com.art.service;

import com.art.entity.Region;
import com.art.exception.RegionNotFoundException;
import com.art.repository.RegionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class RegionServiceImplTest {

    private final RegionServiceImpl regionService;
    private final RegionRepository regionRepository;


    @Autowired
    RegionServiceImplTest(RegionServiceImpl regionService, RegionRepository regionRepository) {
        this.regionService = regionService;
        this.regionRepository = regionRepository;
    }

    @BeforeEach
    void deleteAll() {
        regionRepository.deleteAll();
    }

    @Test
    void findAllTest() {
        List<Region> regionsForSave = new ArrayList<>();
        regionsForSave.add(new Region(1, "Test1"));
        regionsForSave.add(new Region(2, "Test2"));
        regionsForSave.add(new Region(3, "Test3"));
        regionRepository.saveAll(regionsForSave);

        List<Region> foundRegions = regionService.findAll();

        Assertions.assertEquals(regionsForSave.size(), foundRegions.size());
    }

    @Test
    void saveAndFindTest() {
        Region regionForSave = new Region(1, "Test1");
        regionService.save(regionForSave);

        Region foundRegion = regionService.findByRegionCode(regionForSave.getRegionCode());

        Assertions.assertEquals(regionForSave.getRegionCode(), foundRegion.getRegionCode());
        Assertions.assertEquals(regionForSave.getRegionName(), foundRegion.getRegionName());
    }

    @Test
    void updateTest() {
        Region regionForSave = new Region(1, "Test1");
        regionRepository.save(regionForSave);

        String newRegionName = "Test2";
        regionService.update(regionForSave.getRegionCode(), newRegionName);

        Region foundRegion = regionService.findByRegionCode(regionForSave.getRegionCode());
        Assertions.assertEquals(newRegionName, foundRegion.getRegionName());
    }

    @Test
    void deleteTest() {
        Region regionForSave = new Region(1, "Test1");
        regionRepository.save(regionForSave);

        regionService.delete(regionForSave.getRegionCode());

        boolean isExist = regionRepository.existsById(regionForSave.getRegionCode());
        Assertions.assertFalse(isExist);
    }

    @Test
    void saveAndFindShouldThrowsTest() {
        Region regionForSave = new Region(1, "Test1");
        regionService.save(regionForSave);

        Assertions.assertThrows(RegionNotFoundException.class, ()  -> regionService.findByRegionCode(Integer.MAX_VALUE));
    }

}