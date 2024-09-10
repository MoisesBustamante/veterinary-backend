package com.softcaribe.veterinary.manager;


import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface ManagerPacienteInterface {
    public void saveOrUpdate(PacientesDTO pacientesDTO) throws ManagerExceptions;
    public PacientesDTO  findById(PacientesDTO pacientesDTO )throws ManagerExceptions;
    public  void delete(PacientesDTO pacientesDTO)throws ManagerExceptions;
    public List<Map<String, Object>> selectAll()throws ManagerExceptions;
}
