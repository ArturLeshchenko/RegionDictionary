package com.art.entity;

public class Region {
    private Integer regionCode;
    private String regionName;

    public Region(Integer regionCode, String regionName) {
        this.regionCode = regionCode;
        this.regionName = regionName;
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
