package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.UserDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import com.softcaribe.veterinary.manager.ManagerUserInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessUserImplements implements BusinessUserInterface{
    private ManagerUserInterface managerUserInterface;
    public BusinessUserImplements(ManagerUserInterface managerUserInterface){
        this.managerUserInterface=managerUserInterface;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void saveOrUpdate(UserDTO userDTO) throws BusinessExceptions {
        try {
            this.managerUserInterface.saveOrUpdate(userDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public UserDTO findById(UserDTO userDTO) throws BusinessExceptions {
        try {
            return this.managerUserInterface.findById(userDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void delete(UserDTO userDTO) throws BusinessExceptions {
        try {
            this.managerUserInterface.delete(userDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessExceptions {
        try {
            return  this.managerUserInterface.selectAll();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
}
