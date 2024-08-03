package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class VehiculoRepoImpl implements IVehiculoRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Vehiculo v) {
        this.entityManager.persist(v);
    }

    @Override
    public List<Vehiculo> encontrarTodos() {
        String jpql = "SELECT v FROM Vehiculo v";
        TypedQuery<Vehiculo> query = this.entityManager.createQuery(jpql, Vehiculo.class);
        return query.getResultList();
    }

    @Override
    public void eliminar(Vehiculo v) {
        this.entityManager.remove(v);
    }

    @Override
    public Vehiculo encontrarPorPlaca(String placa) {
        String jpql = "SELECT v FROM Vehiculo v WHERE v.placa =: placa";
        TypedQuery<Vehiculo> query = this.entityManager.createQuery(jpql, Vehiculo.class);
        return query.getSingleResult();
    }
    
}
