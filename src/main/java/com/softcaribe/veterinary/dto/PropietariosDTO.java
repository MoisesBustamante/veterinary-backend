package com.softcaribe.veterinary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PropietariosDTO {
    private  String id_dueno;
    private  String tipo_identificacion;
    private  String identificacion_dueno;
    private  String nombre_dueno;
     private CiudadesDTO ciudadesDTO;
    private  String direccion;
    private  String telefono;

}
