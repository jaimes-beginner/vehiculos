package com.example.vehiculo.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/*---------------------------------------------------------*/

// Importaciones
import lombok.AllArgsConstructor;
import lombok.Data;
 
/*---------------------------------------------------------*/

@AllArgsConstructor // crea el contructor de esta clase automaticamente
public @Data class Vehiculo { // @Data crea los getters, setters, y demás complementos para la clase

    // Atributos
    private String id;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @Min(1)
    @Max(99999)
    private int precio;


}
