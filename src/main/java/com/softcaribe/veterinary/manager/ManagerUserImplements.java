package com.softcaribe.veterinary.manager;


import com.softcaribe.veterinary.dao.UserDaoInterface;
import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.UserDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component

public class ManagerUserImplements implements  ManagerUserInterface{
    public UserDaoInterface userDaoInterface;
    public ManagerUserImplements(UserDaoInterface userDaoInterface){
        this.userDaoInterface=userDaoInterface;
    }
    @Override
    public void saveOrUpdate(UserDTO userDTO) throws ManagerExceptions {
        try {
            UserDTO usersFound = this.userDaoInterface.findById(userDTO);
            if (usersFound==null){
                this.userDaoInterface.insert(userDTO);
            }else{
                this.userDaoInterface.update(userDTO);
            }
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public UserDTO findById(UserDTO userDTO) throws ManagerExceptions {
        UserDTO usersFound= null;
        try {
            usersFound= this.userDaoInterface.findById(userDTO);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return usersFound;
    }

    @Override
    public void delete(UserDTO userDTO) throws ManagerExceptions {
        try {
            this.userDaoInterface.delete(userDTO);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerExceptions {
        try {
            return this.userDaoInterface.selectAll();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }
}
