package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// The import org.springframework.web.bind.annotation.RequestParam is not used and can be removed.

import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.TO.VehiculoTO;

@Controller
@RequestMapping(path = "/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    // http://localhost:8080/API/v1.0/Concesionario/vehiculos/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private void guardar(@RequestBody VehiculoTO vehiculoTo) {
        this.vehiculoService.guardar(vehiculoTo);
    }

    // http://localhost:8080/API/v1.0/Concesionario/vehiculos/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Vehiculo> obtenerTodos(){
        return this.vehiculoService.buscarTodos();
    }

}
