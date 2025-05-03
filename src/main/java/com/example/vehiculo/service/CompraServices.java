package com.example.vehiculo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.vehiculo.models.RespuestaCompra;
import com.example.vehiculo.models.SolicitudCompra;
import com.example.vehiculo.models.Vehiculo;

@Service
public class CompraServices {
   
    @Autowired
    private VehiculoServices vehiculoServicio;

    public RespuestaCompra comprar(SolicitudCompra soli) {
        RespuestaCompra respuesta = new RespuestaCompra();
        try {
            Vehiculo vehi = vehiculoServicio.obtenerUnoServ(soli.getIdVehiculo());
            // Aqui va la comunicación con el microservicio usuario y verificar que existe

            // Usar intergración para ver si la tarjeta pudo comprar la wea

            // Llamar al repostorio de compra y agregarla 

            // Eliminar el vehiculo porque ya se vendió

            vehiculoServicio.eliminarVehiculoServ(soli.getIdVehiculo());
            respuesta.setNumeroBoleta("1234");
            Date fechaEn = new Date(); // Podriamos calcular la fecha de entrega
            respuesta.setFechaEntrega(fechaEn);
            respuesta.setExito(true);
        }   catch (Exception e) {
            respuesta.setExito(false);
        }
        return respuesta;
    }


}
