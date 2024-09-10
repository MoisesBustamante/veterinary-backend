package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.mapper.PacientesMapper;
import com.softcaribe.veterinary.mapper.PropietariosMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository
public class PropietarioDaoImplements implements PropietarioDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public PropietarioDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void insert(PropietariosDTO propietariosDTO) throws DaoExceptions {
        String INSERT = "INSERT INTO propietarios(id_dueno, tipo_identificacion, identificacion_dueno, nombre_dueno, id_ciudad, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT,
                propietariosDTO.getId_dueno(),
                propietariosDTO.getTipo_identificacion(),
                propietariosDTO.getIdentificacion_dueno(),
                propietariosDTO.getNombre_dueno(),
                propietariosDTO.getCiudadesDTO().getId_ciudad(),
                propietariosDTO.getDireccion(),
                propietariosDTO.getTelefono());
        return;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoExceptions {
        try {
            String SQL="SELECT id_dueno, tipo_identificacion, identificacion_dueno, nombre_dueno, id_ciudad, direccion, telefono FROM propietarios";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public PropietariosDTO findById(PropietariosDTO propietariosDTO) throws DaoExceptions {
        try {
            String QUERY="SELECT id_dueno, tipo_identificacion, identificacion_dueno, nombre_dueno, id_ciudad, direccion, telefono FROM propietarios WHERE id_dueno=?";
            return  jdbcTemplate.queryForObject(QUERY,new PropietariosMapper(),propietariosDTO.getId_dueno());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void update(PropietariosDTO propietariosDTO) throws DaoExceptions {
        try {
            String UPDATE="UPDATE propietarios SET  tipo_identificacion=?, identificacion_dueno=?, nombre_dueno=?, id_ciudad=?, direccion=?, telefono=? WHERE  id_dueno=?";
            jdbcTemplate.update(UPDATE,
                    propietariosDTO.getTipo_identificacion(),
                    propietariosDTO.getIdentificacion_dueno(),
                    propietariosDTO.getNombre_dueno(),
                    propietariosDTO.getCiudadesDTO().getId_ciudad(),
                    propietariosDTO.getDireccion(),
                    propietariosDTO.getTelefono(),
                    propietariosDTO.getId_dueno());

        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;

    }

    @Override
    public void delete(PropietariosDTO propietariosDTO) throws DaoExceptions {
        String DELETE = "DELETE FROM propietarios WHERE id_dueno=?";

        jdbcTemplate.update(DELETE, propietariosDTO.getId_dueno());

        return;

    }
}
