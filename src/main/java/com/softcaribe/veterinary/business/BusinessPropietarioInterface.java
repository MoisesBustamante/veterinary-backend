package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessPropietarioInterface {
    public void saveOrUpdate(PropietariosDTO propietariosDTO) throws BusinessExceptions;
    public PropietariosDTO findById(PropietariosDTO propietariosDTO) throws BusinessExceptions;
    public  void delete(PropietariosDTO propietariosDTO)throws BusinessExceptions;
    public List<Map<String, Object>> selectAll() throws BusinessExceptions;
}
