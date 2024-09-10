package com.softcaribe.veterinary.manager;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.UserDTO;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface ManagerUserInterface {
    public void saveOrUpdate(UserDTO userDTO) throws ManagerExceptions;
    public UserDTO findById(UserDTO userDTO )throws ManagerExceptions;
    public  void delete(UserDTO userDTO)throws ManagerExceptions;
    public List<Map<String, Object>> selectAll()throws ManagerExceptions;
}
