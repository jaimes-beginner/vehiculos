package com.example.vehiculo.models;

/*---------------------------------------------------------*/

// Importaciónes
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

/*---------------------------------------------------------*/

public @Data class ModificarVehiculo {
    
    @Min(1)
    @Max(99999)
    private int precio;

}
