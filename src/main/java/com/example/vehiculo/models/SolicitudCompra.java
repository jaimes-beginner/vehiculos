package com.example.vehiculo.models;

/*---------------------------------------------------------*/

// Importaciones
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*---------------------------------------------------------*/

public @Data class SolicitudCompra {
    
    @NotBlank
    private String idVehiculo;

    @NotBlank
    @Email
    private String correoUsuario;

    @NotBlank
    private String numeroTarjeta;

    @NotBlank
    private String cvc;


}
