package com.example.vehiculo.controllers;

/*---------------------------------------------------------*/

// Importaciones
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.vehiculo.models.ModificarVehiculo;
import com.example.vehiculo.models.Vehiculo;
import com.example.vehiculo.service.VehiculoServices;
import jakarta.validation.Valid;

/*---------------------------------------------------------*/

@RestController // Esta clase contralá peticiones HTTP
@RequestMapping("/vehiculo") // Definir una ruta para el endpoint
public class VehiculoController {
    
    // Atributos
    @Autowired
    private VehiculoServices vehiServices;

    // Obtener todos los vehiculos de la 'base de datos'
    @GetMapping("")
    public ArrayList<Vehiculo> todos() {
        return vehiServices.obtenerTodos();
    }

    // Obtener un vehiculo de la 'base de datos'
    @GetMapping("/{id}")
    public Vehiculo obtenerUno(@PathVariable String id) {
        System.out.println("> > > Buscando id: "+id);
        return vehiServices.obtenerUno(id);
    }

    // Eliminar un vehiculo de la 'base de datos'
    @DeleteMapping("/{id}")
    public String eliminarVehiculo(@PathVariable String id) {
        vehiServices.eliminarVehiculo(id);
        return "Eliminado!";
    }

    // Agregar un vehiculo 
    @PostMapping("") // Para agregar algo nuevo (un vehiculo)
    public String agregar(@Valid @RequestBody Vehiculo vehi) {
        vehiServices.agregar(vehi);
        return "Agregado";
    }

    // Modificar precio del vehiculo
    @PutMapping("/{id}")
    public String modificarVehiculo(@PathVariable String id, @RequestBody ModificarVehiculo vehi) {
        vehiServices.modificar(vehi, id);
        return "Modificado!";
    }

}
