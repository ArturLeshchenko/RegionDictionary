package com.art.dao;

import com.art.entity.Region;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RegionDaoImpl implements  RegionDao {

    private final DataSource dataSource;

    public RegionDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Region> findAll() throws Exception {
        List <Region> regions = new ArrayList<Region>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from region");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int regionCode = resultSet.getInt("region_code");
            String regionName = resultSet.getString("region_name");
            Region region = new Region(regionCode, regionName);
            regions.add(region);
        }
        return regions;
    }


    @Override
    public Region findByRegionCode(int regionCode) {
        return null;
    }

    @Override
    public void save(Region region) {

    }

    @Override
    public void update(int regionCode, String regionName) {

    }

    @Override
    public void delete(int regionCode) {

    }
}
