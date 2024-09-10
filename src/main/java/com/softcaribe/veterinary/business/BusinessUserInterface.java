package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.UserDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessUserInterface {

    public void saveOrUpdate(UserDTO userDTO) throws BusinessExceptions;
    public UserDTO  findById(UserDTO userDTO) throws BusinessExceptions;
    public  void delete(UserDTO userDTO)throws BusinessExceptions;
    public List<Map<String, Object>> selectAll() throws BusinessExceptions;
}
