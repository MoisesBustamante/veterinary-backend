package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessPacienteInterface {
    public void saveOrUpdate(PacientesDTO pacientesDTO) throws BusinessExceptions;
    public PacientesDTO  findById(PacientesDTO pacientesDTO) throws BusinessExceptions;
    public  void delete(PacientesDTO pacientesDTO)throws BusinessExceptions;
    public List<Map<String, Object>> selectAll() throws BusinessExceptions;
}
