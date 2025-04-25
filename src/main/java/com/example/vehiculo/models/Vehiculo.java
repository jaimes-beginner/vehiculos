package com.example.vehiculo.models;

/*---------------------------------------------------------*/

// Importaciones
import lombok.AllArgsConstructor;
import lombok.Data;
 
/*---------------------------------------------------------*/

@AllArgsConstructor // crea el contructor de esta clase automaticamente
public @Data class Vehiculo { // @Data crea los getters, setters, y demás complementos para la clase

    // Atributos
    private String id;
    private String marca;
    private String modelo;
    private int precio;

}
