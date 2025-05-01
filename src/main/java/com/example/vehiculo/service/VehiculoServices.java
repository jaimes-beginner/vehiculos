package com.example.vehiculo.service;

/*---------------------------------------------------------*/

// Importaciones
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.vehiculo.models.ModificarVehiculo;
import com.example.vehiculo.models.Vehiculo;
import com.example.vehiculo.repository.VehiculoRepository;

/*---------------------------------------------------------*/

@Service // Esta clase se hará cargo de la lógica del negocio
public class VehiculoServices {
    /*------------------------------------------------------------*/
    // Atributos
    @Autowired
    private VehiculoRepository vehiRepoServ;
    /*------------------------------------------------------------*/
    // Agregando un vehiculo
    public void agregarVehiculoServ(Vehiculo vehi) {
        vehi.setId(UUID.randomUUID().toString());
        vehiRepoServ.insertarVehiculoRepo(vehi);
    }
    /*------------------------------------------------------------*/
    // Obtener todos los vehiculos
    public ArrayList<Vehiculo> obtenerTodosServ() {
        return vehiRepoServ.obtenerTodosRepo();
    }
    /*------------------------------------------------------------*/
    // Obtener un vehiculo
    public Vehiculo obtenerUnoServ(String id) {
        Vehiculo vehi = vehiRepoServ.obtenerUnoRepo(id);
        if(vehi == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return vehi;
    }
    /*------------------------------------------------------------*/
    // Eliminar vehiculo
    public void eliminarVehiculoServ(String id) {
        Vehiculo vehi = vehiRepoServ.obtenerUnoRepo(id);
        if(vehi == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        vehiRepoServ.eliminarVehiculoRepo(vehi);
    }
    /*------------------------------------------------------------*/
    // Modificar precio del vehiculo
    public void modificarVehiculoServ(ModificarVehiculo modVehiculo, String id) {
        Vehiculo vehi = obtenerUnoServ(id);
        vehi.setPrecio(modVehiculo.getPrecio());
    }
    /*------------------------------------------------------------*/
}
