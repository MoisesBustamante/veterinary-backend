package com.softcaribe.veterinary.manager;

import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface ManagerPropietarioInterface {
    public void saveOrUpdate(PropietariosDTO propietariosDTO) throws ManagerExceptions;
    public PropietariosDTO findById(PropietariosDTO propietariosDTO )throws ManagerExceptions;
    public  void delete(PropietariosDTO propietariosDTO)throws ManagerExceptions;
    public List<Map<String, Object>> selectAll()throws ManagerExceptions;
}
