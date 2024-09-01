package com.art.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @Column(name = "region_code")
    private Integer regionCode;
    @Column(name = "region_name")
    private String regionName;

    public Region(Integer regionCode, String regionName) {
        this.regionCode = regionCode;
        this.regionName = regionName;
    }

    public Region() {

    }

    @Override
    public String toString() {
        return "Region{" +
                "regionCode=" + regionCode +
                ", regionName='" + regionName + '\'' +
                '}';
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }


    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
