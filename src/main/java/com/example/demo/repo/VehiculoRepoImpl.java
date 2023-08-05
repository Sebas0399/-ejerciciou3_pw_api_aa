package com.example.demo.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class VehiculoRepoImpl implements IVehiculoRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Vehiculo> getAll() {
        TypedQuery<Vehiculo>myQuery=this.entityManager.createQuery("SELECT v FROM Vehiculo v",Vehiculo.class);

        return myQuery.getResultList();
    }

    @Override
    public Vehiculo get(Integer id) {
        return this.entityManager.find(Vehiculo.class,id);
    }

    @Override
    public Vehiculo getByPlaca(String placa) {
        TypedQuery<Vehiculo>myQuery=this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=:placa",Vehiculo.class);
        myQuery.setParameter("placa",placa);
        return myQuery.getSingleResult();
    }
}
