package com.softcaribe.veterinary.manager;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface ManagerCiudadInterface {
    public void saveOrUpdate(CiudadesDTO  ciudadesDTO) throws ManagerExceptions;
    public CiudadesDTO findById(CiudadesDTO ciudadesDTO )throws ManagerExceptions;
    public  void delete(CiudadesDTO ciudadesDTO)throws ManagerExceptions;
    public List<Map<String, Object>> selectAll()throws ManagerExceptions;
}
