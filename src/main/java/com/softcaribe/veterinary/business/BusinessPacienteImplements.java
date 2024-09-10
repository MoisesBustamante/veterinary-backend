package com.softcaribe.veterinary.business;

import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.exceptions.BusinessExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import com.softcaribe.veterinary.manager.ManagerPacienteInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessPacienteImplements implements  BusinessPacienteInterface{
    private ManagerPacienteInterface managerPacienteInterface;
    public BusinessPacienteImplements(ManagerPacienteInterface managerPacienteInterface){
        this.managerPacienteInterface=managerPacienteInterface;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void saveOrUpdate(PacientesDTO pacientesDTO) throws BusinessExceptions {
        try {
            this.managerPacienteInterface.saveOrUpdate(pacientesDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }

    @Transactional(readOnly = true)
    public PacientesDTO findById(PacientesDTO pacientesDTO) throws BusinessExceptions {
        try {
            return this.managerPacienteInterface.findById(pacientesDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void delete(PacientesDTO pacientesDTO) throws BusinessExceptions {
        try {
            this.managerPacienteInterface.delete(pacientesDTO);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessExceptions {
        try {
            return  this.managerPacienteInterface.selectAll();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
}
