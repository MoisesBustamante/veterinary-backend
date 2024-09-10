package com.softcaribe.veterinary.dao;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface PacienteDaoInterface {
    void insert(PacientesDTO pacientesDTO) throws DaoExceptions;

    public List<Map<String,Object>> selectAll()throws DaoExceptions;
    PacientesDTO findById(PacientesDTO pacientesDTO)throws DaoExceptions;
    void update(PacientesDTO pacientesDTO)throws DaoExceptions;
    void delete(PacientesDTO pacientesDTO)throws DaoExceptions;

}
