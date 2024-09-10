package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import com.softcaribe.veterinary.manager.ManagerCiudadInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessCiudadImplements implements BusinessCiudadInterface {
    private ManagerCiudadInterface managerCiudadInterface;
    public BusinessCiudadImplements(ManagerCiudadInterface managerCiudadInterface){
        this.managerCiudadInterface=managerCiudadInterface;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void saveOrUpdate(CiudadesDTO ciudadesDTO) throws BusinessExceptions {
        try {
            this.managerCiudadInterface.saveOrUpdate(ciudadesDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public CiudadesDTO findById(CiudadesDTO ciudadesDTO) throws BusinessExceptions {
        try {
           return this.managerCiudadInterface.findById(ciudadesDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void delete(CiudadesDTO ciudadesDTO) throws BusinessExceptions {
        try {
            this.managerCiudadInterface.delete(ciudadesDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessExceptions {
        try {
            return  this.managerCiudadInterface.selectAll();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
}
