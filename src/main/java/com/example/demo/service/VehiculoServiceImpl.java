package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IVehiculoRepo;
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.service.TO.VehiculoTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepo vehiculoRepo;

    @Override
    public void guardar(VehiculoTO vehiculoTO) {
        this.vehiculoRepo.insertar(this.conversion(vehiculoTO));
    }

    public Vehiculo conversion(VehiculoTO vehiculoTO) {
        Vehiculo v = Vehiculo.builder()
                .placa(vehiculoTO.getPlaca())
                .marca(vehiculoTO.getMarca())
                .modelo(vehiculoTO.getModelo())
                .color(vehiculoTO.getColor())
                .precio(vehiculoTO.getPrecio())
                .build();
        return v;
    }

    @Override
    public List<Vehiculo> buscarTodos() {
        return this.vehiculoRepo.encontrarTodos();
    }

    @Override
    public Vehiculo buscarPorPlaca(String placa) {
        return this.vehiculoRepo.encontrarPorPlaca(placa);
    }

    @Override
    public void borrar(VehiculoTO vehiculoTO) {
        Vehiculo vAux = this.buscarPorPlaca(vehiculoTO.getPlaca());
        this.vehiculoRepo.eliminar(vAux);
    }

}
