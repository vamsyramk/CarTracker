package io.vamsy.repository;

import io.vamsy.entity.Vehicle;
import io.vamsy.repository.interfaces.VehicleRespository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by vamsyramk on 6/27/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRespository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class,vin);
    }

    public void create(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public Vehicle update(String vin, Vehicle vehicle) {

        return entityManager.merge(vehicle);
    }

    public void delete(String id) {

    }
}
