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
    private VehiculoServices vehiServicesContr;

    // Obtener todos los vehiculos de la 'base de datos'
    @GetMapping("")
    public ArrayList<Vehiculo> todosServ() {
        return vehiServicesContr.obtenerTodosServ();
    }

    // Obtener un vehiculo de la 'base de datos'
    @GetMapping("/{id}")
    public Vehiculo obtenerUnoContr(@PathVariable String id) {
        System.out.println("> > > Buscando id: "+id);
        return vehiServicesContr.obtenerUnoServ(id);
    }

    // Eliminar un vehiculo de la 'base de datos'
    @DeleteMapping("/{id}")
    public String eliminarVehiculoContr(@PathVariable String id) {
        vehiServicesContr.eliminarVehiculoServ(id);
        return "Eliminado!";
    }

    // Agregar un vehiculo 
    @PostMapping("") // Para agregar algo nuevo (un vehiculo)
    public String agregarVehiculoContr(@Valid @RequestBody Vehiculo vehi) {
        vehiServicesContr.agregarVehiculoServ(vehi);
        return "Agregado";
    }

    // Modificar precio del vehiculo
    @PutMapping("/{id}")
    public String modificarVehiculoContr(@PathVariable String id, @RequestBody ModificarVehiculo vehi) {
        vehiServicesContr.modificarVehiculoServ(vehi, id);
        return "Modificado!";
    }

}
