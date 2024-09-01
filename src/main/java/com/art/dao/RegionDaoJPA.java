package com.art.dao;

import com.art.entity.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class RegionDaoJPA implements RegionDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public RegionDaoJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Region> findAll() {
        return entityManager.createQuery("select region from Region region", Region.class).getResultList();
    }

    @Override
    public Optional<Region> findByRegionCode(int regionCode) {
        return Optional.ofNullable(entityManager.find(Region.class, regionCode));
    }

    @Override
    @Transactional
    public void save(Region region) {
        entityManager.persist(region);
    }

    @Override
    @Transactional
    public void update(int regionCode, String regionName) {
        entityManager.merge(new Region(regionCode, regionName));
    }

    @Override
    @Transactional
    public void delete(int regionCode) {
        entityManager.remove(entityManager.find(Region.class, regionCode));
    }
}

