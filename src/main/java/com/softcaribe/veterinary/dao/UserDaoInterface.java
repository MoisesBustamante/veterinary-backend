package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.dto.UserDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface UserDaoInterface {
    void insert(UserDTO userDTO) throws DaoExceptions;

    public List<Map<String,Object>> selectAll()throws DaoExceptions;
    UserDTO  findById(UserDTO userDTO)throws DaoExceptions;
    void update(UserDTO userDTO)throws DaoExceptions;
    void delete(UserDTO userDTO)throws DaoExceptions;
}
