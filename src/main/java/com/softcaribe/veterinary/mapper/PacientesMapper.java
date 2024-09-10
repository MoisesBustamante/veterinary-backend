package com.softcaribe.veterinary.mapper;



import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.dto.PropietariosDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientesMapper implements RowMapper<PacientesDTO> {
    @Override
    public PacientesDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        PacientesDTO p= new PacientesDTO();
        PropietariosDTO propietarios= new PropietariosDTO();
        p.setNombre_mascota(resultSet.getString("nombre_mascota"));
        p.setEspecie(resultSet.getString("especie"));
        p.setRaza(resultSet.getString("raza"));
        p.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
        propietarios.setId_dueno(resultSet.getString("id_dueno"));
        p.setPropietariosDTO(propietarios);

        return p;
    }
}
