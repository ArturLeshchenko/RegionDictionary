package com.art.dao;

import com.art.entity.Region;
import com.art.exception.SqlProcessingException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RegionDaoImpl implements RegionDao {
    private static final String FIND_ALL = "select * from region";
    private static final String FIND_BY_REGION_CODE = "select * from region where region_code=?";
    private static final String SAVE = "insert into region (region_code, region_name) values (?, ?)";
    private static final String UPDATE = "update region set region_name=? where region_code=?";
    private static final String DELETE = "delete from region where region_code=?";
    private final DataSource dataSource;

    public RegionDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Region> findAll() {
        List<Region> regions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int regionCode = resultSet.getInt("region_code");
                String regionName = resultSet.getString("region_name");
                Region region = new Region(regionCode, regionName);
                regions.add(region);
            }
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
        return regions;
    }

    @Override
    public Optional<Region> findByRegionCode(int regionCode) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_REGION_CODE);
            preparedStatement.setInt(1, regionCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String regionName = resultSet.getString("region_name");
                return Optional.of(new Region(regionCode, regionName));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    @Override
    public void save(Region region)  {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setInt(1, region.getRegionCode());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    @Override
    public void update(int regionCode, String regionName)  {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, regionName);
            preparedStatement.setInt(2, regionCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    @Override
    public void delete(int regionCode)  {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, regionCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }
}
