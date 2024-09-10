package com.softcaribe.veterinary.mapper;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadesMapper implements RowMapper<CiudadesDTO> {
    @Override
    public CiudadesDTO mapRow(ResultSet resultSet, int i)throws SQLException {
        CiudadesDTO ciu= new CiudadesDTO();
        ciu.setId_ciudad(resultSet.getString("id_ciudad"));
        ciu.setNombre_ciudad(resultSet.getString("nombre_ciudad"));
        return ciu;


    }
}
