package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.mapper.CiudadesMapper;
import com.softcaribe.veterinary.mapper.PacientesMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository

public class PacienteDaoImplements implements PacienteDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public PacienteDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void insert(PacientesDTO pacientesDTO) throws DaoExceptions {
        String INSERT = "INSERT INTO pacientes(id_mascota, nombre_mascota, especie, raza, fecha_nacimiento, id_dueno) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(INSERT,
                pacientesDTO.getId_mascota(),
                pacientesDTO.getNombre_mascota(),
                pacientesDTO.getEspecie(),
                pacientesDTO.getRaza(),
                pacientesDTO.getFecha_nacimiento(),
                pacientesDTO.getPropietariosDTO().getId_dueno());

        return;
    }


    @Override
    public List<Map<String, Object>> selectAll() throws DaoExceptions {
        try {
            String SQL="SELECT id_mascota, nombre_mascota, especie, raza, fecha_nacimiento, id_dueno FROM pacientes";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

    }

    @Override
    public PacientesDTO findById(PacientesDTO pacientesDTO) throws DaoExceptions {
        try {
            String QUERY="SELECT id_mascota, nombre_mascota, especie, raza, fecha_nacimiento, id_dueno FROM pacientes WHERE id_mascota=?";
            return  jdbcTemplate.queryForObject(QUERY,new PacientesMapper(),pacientesDTO.getId_mascota());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }

    }

    @Override
    public void update(PacientesDTO pacientesDTO) throws DaoExceptions {
        try {
            String UPDATE="UPDATE pacientes SET  nombre_mascota=?, especie=?, raza=?, fecha_nacimiento=?, id_dueno=? WHERE  id_mascota=?";
            jdbcTemplate.update(UPDATE,
                    pacientesDTO.getNombre_mascota(),
                    pacientesDTO.getEspecie(),
                    pacientesDTO.getRaza(),
                    pacientesDTO.getFecha_nacimiento(),
                    pacientesDTO.getPropietariosDTO().getId_dueno(),
                    pacientesDTO.getId_mascota());

        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;

    }

    @Override
    public void delete(PacientesDTO pacientesDTO) throws DaoExceptions {
        String DELETE = "DELETE FROM pacientes WHERE id_mascota=?";

        jdbcTemplate.update(DELETE, pacientesDTO.getId_mascota());

        return;

    }
}
