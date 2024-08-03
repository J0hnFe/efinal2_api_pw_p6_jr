package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.service.TO.VehiculoTO;

public interface IVehiculoService {
    public void guardar(VehiculoTO v);

    public List<Vehiculo> buscarTodos();
    public Vehiculo buscarPorPlaca(String placa);

    public void borrar(VehiculoTO vehiculoTO);
}
