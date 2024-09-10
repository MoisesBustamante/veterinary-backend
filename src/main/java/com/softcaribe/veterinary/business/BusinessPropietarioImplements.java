package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import com.softcaribe.veterinary.manager.ManagerPropietarioInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessPropietarioImplements implements BusinessPropietarioInterface{
    private ManagerPropietarioInterface managerPropietarioInterface;
    public BusinessPropietarioImplements(ManagerPropietarioInterface managerPropietarioInterface){
        this.managerPropietarioInterface=managerPropietarioInterface;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void saveOrUpdate(PropietariosDTO propietariosDTO) throws BusinessExceptions {
        try {
            this.managerPropietarioInterface.saveOrUpdate(propietariosDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public PropietariosDTO findById(PropietariosDTO propietariosDTO) throws BusinessExceptions {
        try {
            return this.managerPropietarioInterface.findById(propietariosDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void delete(PropietariosDTO propietariosDTO) throws BusinessExceptions {
        try {
            this.managerPropietarioInterface.delete(propietariosDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessExceptions {
        try {
            return  this.managerPropietarioInterface.selectAll();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
}
