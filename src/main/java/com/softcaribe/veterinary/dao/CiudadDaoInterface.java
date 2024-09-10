package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface CiudadDaoInterface {
    void insert(CiudadesDTO ciudadesDTO) throws DaoExceptions;

    public List<Map<String,Object>> selectAll()throws DaoExceptions;
    CiudadesDTO findById(CiudadesDTO ciudadesDTO)throws DaoExceptions;
    void update(CiudadesDTO ciudadesDTO)throws DaoExceptions;
    void delete(CiudadesDTO ciudadesDTO)throws DaoExceptions;
}
