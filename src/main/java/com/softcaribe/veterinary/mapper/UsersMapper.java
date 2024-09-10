package com.softcaribe.veterinary.mapper;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDTO us= new UserDTO();
        us.setId_user(resultSet.getString("id_user"));
        us.setUsername(resultSet.getString("username"));
        us.setPassword(resultSet.getString("password"));
        us.setEmail(resultSet.getString("email"));
        us.setRole(resultSet.getString("role"));
        return us;
    }
}
