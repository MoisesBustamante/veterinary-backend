package com.softcaribe.veterinary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class PacientesDTO {
    private  String id_mascota;
    private  String nombre_mascota;
    private  String especie;
    private  String raza;
    private Date fecha_nacimiento;
   private PropietariosDTO propietariosDTO;

}
