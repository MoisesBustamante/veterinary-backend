package com.softcaribe.veterinary.dao;


import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface PropietarioDaoInterface {
    void insert(PropietariosDTO propietariosDTO) throws DaoExceptions;

    public List<Map<String,Object>> selectAll()throws DaoExceptions;
    PropietariosDTO findById(PropietariosDTO propietariosDTO)throws DaoExceptions;
    void update(PropietariosDTO propietariosDTO)throws DaoExceptions;
    void delete(PropietariosDTO propietariosDTO)throws DaoExceptions;
}
