package com.example.vehiculo.service;

/*---------------------------------------------------------*/

// Importaciones
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.vehiculo.models.Vehiculo;
import com.example.vehiculo.repository.VehiculoRepository;

/*---------------------------------------------------------*/

@Service // Esta clase se hará cargo de la lógica del negocio
public class VehiculoServices {
    
    @Autowired
    private VehiculoRepository vehiRepo;

    // Obtener todos los vehiculos
    public ArrayList<Vehiculo> obtenerTodos() {
        return vehiRepo.obtenerTodos();
    }

    // Obtener un vehiculo
    public Vehiculo obtenerUno(String id) {
        Vehiculo vehi = vehiRepo.obtenerUno(id);
        if(vehi == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return vehi;
    }

    // Eliminar vehiculo
    public void eliminarVehiculo(String id) {
        Vehiculo vehi = vehiRepo.obtenerUno(id);
        if(vehi == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        vehiRepo.eliminarVehiculo(vehi);
    }

}
