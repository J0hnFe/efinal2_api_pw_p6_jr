package com.example.demo.repo;

import com.example.demo.repo.modelo.Vehiculo;
import java.util.List;

public interface IVehiculoRepo {
    public void insertar(Vehiculo v);

    public List<Vehiculo> encontrarTodos();

    public Vehiculo encontrarPorPlaca(String placa);

    public void eliminar(Vehiculo v);
    
}
