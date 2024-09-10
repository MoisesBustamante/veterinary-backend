package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.UserDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.mapper.PropietariosMapper;
import com.softcaribe.veterinary.mapper.UsersMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository

public class UserDaoImplements implements UserDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public UserDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void insert(UserDTO userDTO) throws DaoExceptions {
        String INSERT = "INSERT INTO users(id_user, username, password, email, role) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT,
                userDTO.getId_user(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.getRole());
        return;
    }



    @Override
    public List<Map<String, Object>> selectAll() throws DaoExceptions {
        try {
            String SQL="SELECT id_user, username, password, email, role FROM users";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }


    @Override
    public UserDTO findById(UserDTO userDTO) throws DaoExceptions {
        try {
            String QUERY="SELECT id_user, username, password, email, role FROM users WHERE id_user=?";
            return  jdbcTemplate.queryForObject(QUERY,new UsersMapper(),userDTO.getId_user());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void update(UserDTO userDTO) throws DaoExceptions {
        try {
            String UPDATE="UPDATE users SET  username=?, password=?, email=?, role=? WHERE  id_user=?";
            jdbcTemplate.update(UPDATE,
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getEmail(),
                    userDTO.getRole(),
                    userDTO.getId_user());

        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;

    }


    @Override
    public void delete(UserDTO userDTO) throws DaoExceptions {
        String DELETE = "DELETE FROM users WHERE id_user=?";

        jdbcTemplate.update(DELETE, userDTO.getId_user());

        return;
    }
}
