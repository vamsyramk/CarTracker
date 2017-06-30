package io.vamsy.repository;

import io.vamsy.entity.Alert;
import io.vamsy.entity.Reading;
import io.vamsy.repository.interfaces.ReadingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by vamsyramk on 6/28/2017.
 */

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public Alert create(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }
    public Reading ingest(Reading reading) {
        entityManager.persist(reading.getTires());
        entityManager.persist(reading);
        return reading;
    }
}
