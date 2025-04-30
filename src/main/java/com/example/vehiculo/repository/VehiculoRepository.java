package com.example.vehiculo.repository;

/*---------------------------------------------------------*/

// Importaciones
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.vehiculo.models.Vehiculo;

/*---------------------------------------------------------*/

@Repository
public class VehiculoRepository {
    
    // Atributos
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    // Simulación de datos de vehiculo
    public VehiculoRepository() {
        listaVehiculos.add(new Vehiculo("1","Chevrolet","Sail",8000));
        listaVehiculos.add(new Vehiculo("2","Cherry","Tiggo",18000));
        listaVehiculos.add(new Vehiculo("3","Subaru","Impreza",40000));
    }

    // Obtener todos los vehiculos
    public ArrayList<Vehiculo> obtenerTodosRepo() {
        return listaVehiculos;
    }

    // Obtener un vehiculo
    public Vehiculo obtenerUnoRepo(String id) {
        for (Vehiculo vehi : listaVehiculos) {
            if(vehi.getId().equals(id)) {
                return vehi;
            }
        }
        return null;
    }

    // Insertar un vehiculo
    public void insertarVehiculoRepo(Vehiculo nuevoVehiculo) {
        listaVehiculos.add(nuevoVehiculo);
    }

    // Eliminar un vehiculo
    public void eliminarVehiculoRepo(Vehiculo chaitoVehiculo) {
        listaVehiculos.remove(chaitoVehiculo);
    }
    
}
