package com.softcaribe.veterinary.mapper;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.dto.PropietariosDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropietariosMapper implements RowMapper<PropietariosDTO> {
    @Override
    public PropietariosDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        PropietariosDTO p= new PropietariosDTO();
        CiudadesDTO ciudades= new CiudadesDTO();
        p.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
        p.setIdentificacion_dueno(resultSet.getString("identificacion_dueno"));
        p.setNombre_dueno(resultSet.getString("nombre_dueno"));
        ciudades.setId_ciudad(resultSet.getString("id_ciudad"));
        p.setDireccion(resultSet.getString("direccion"));
        p.setTelefono(resultSet.getString("telefono"));
        p.setCiudadesDTO(ciudades);

        return p;
    }
}
