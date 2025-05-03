package com.example.vehiculo.models;
 
/*---------------------------------------------------------*/

// Importaciónes
import java.sql.Date;
import lombok.Data;

/*---------------------------------------------------------*/

public @Data class RespuestaCompra {
    
    private Boolean exito;
    private String numeroBoleta;
    private Date fechaEntrega;

}
