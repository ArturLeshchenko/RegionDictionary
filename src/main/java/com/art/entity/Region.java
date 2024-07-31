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
}
