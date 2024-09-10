package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.mapper.CiudadesMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository

public class CiudadDaoImplements  implements CiudadDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public CiudadDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void insert(CiudadesDTO ciudadesDTO) {
        String INSERT="INSERT INTO ciudad(id_ciudad, nombre_ciudad) VALUES (?, ?)";
        jdbcTemplate.update(INSERT,
                ciudadesDTO.getId_ciudad(),
                ciudadesDTO.getNombre_ciudad());
        return;

    }



    @Override
    public List<Map<String, Object>> selectAll() throws DaoExceptions {
        try {
            String SQL="SELECT id_ciudad, nombre_ciudad FROM ciudad";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

    }

    @Override
    public CiudadesDTO findById(CiudadesDTO ciudadesDTO){
        try {
            String QUERY="SELECT id_ciudad, nombre_ciudad FROM ciudad WHERE id_ciudad=?";
            return  jdbcTemplate.queryForObject(QUERY,new CiudadesMapper(),ciudadesDTO.getId_ciudad());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }

    }

    @Override
    public void update(CiudadesDTO ciudadesDTO) throws DaoExceptions {
        try {
            String UPDATE="UPDATE ciudad SET  nombre_ciudad=? WHERE  id_ciudad=?";
            jdbcTemplate.update(UPDATE,
                    ciudadesDTO.getNombre_ciudad(),
                    ciudadesDTO.getId_ciudad());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;

    }

    @Override
    public void delete(CiudadesDTO ciudadesDTO) throws DaoExceptions {
        String DELETE = "DELETE FROM ciudad WHERE id_ciudad=?";
        try {
            jdbcTemplate.update(DELETE, ciudadesDTO.getId_ciudad());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }
}
