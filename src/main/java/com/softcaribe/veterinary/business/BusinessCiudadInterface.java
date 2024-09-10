package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessCiudadInterface {
    public void saveOrUpdate(CiudadesDTO ciudadesDTO) throws BusinessExceptions;
    public CiudadesDTO findById(CiudadesDTO  ciudadesDTO) throws BusinessExceptions;
    public  void delete(CiudadesDTO ciudadesDTO)throws BusinessExceptions;
    public List<Map<String, Object>> selectAll() throws BusinessExceptions;
}
