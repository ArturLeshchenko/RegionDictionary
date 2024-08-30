package com.art.controller;

import com.art.entity.Region;
import com.art.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/api/v1/regions")
    public List<Region> getAllRegions() {
        return regionService.findAll();
    }

    @GetMapping("/api/v1/region/{regionCode}")
    public Region findByRegionCode(@PathVariable(name = "regionCode") int regionCode) {
        return regionService.findByRegionCode(regionCode);
    }

    @PostMapping("/api/v1/region")
    public void save(@RequestBody Region region) {
        regionService.save(region);
    }

    @DeleteMapping("/api/v1/region/{regionCode}")
    public void delete(@PathVariable(name = "regionCode") int regionCode) {
        regionService.delete(regionCode);
    }

    @PutMapping("/api/v1/region/{regionCode}")
    public void update(@PathVariable int regionCode, @RequestBody String regionName)  {
        regionService.update(regionCode, regionName);
    }

}
