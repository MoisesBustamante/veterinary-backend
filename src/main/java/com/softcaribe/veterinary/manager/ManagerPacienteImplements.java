package com.softcaribe.veterinary.manager;


import com.softcaribe.veterinary.dao.PacienteDaoInterface;
import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component

public class ManagerPacienteImplements implements  ManagerPacienteInterface{
    public PacienteDaoInterface pacienteDaoInterface;
    public ManagerPacienteImplements(PacienteDaoInterface pacienteDaoInterface){
        this.pacienteDaoInterface= pacienteDaoInterface;
    }
    @Override
    public void saveOrUpdate(PacientesDTO pacientesDTO) throws ManagerExceptions {
        try {
            PacientesDTO pacientesFound = this.pacienteDaoInterface.findById(pacientesDTO);
            if (pacientesFound==null){
                this.pacienteDaoInterface.insert(pacientesDTO);
            }else{
                this.pacienteDaoInterface.update(pacientesDTO);
            }
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public PacientesDTO findById(PacientesDTO pacientesDTO) throws ManagerExceptions {
        PacientesDTO pacientesFound= null;
        try {
            pacientesFound= this.pacienteDaoInterface.findById(pacientesDTO);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return pacientesFound;
    }

    @Override
    public void delete(PacientesDTO pacientesDTO) throws ManagerExceptions {
        try {
            this.pacienteDaoInterface.delete(pacientesDTO);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerExceptions {
        try {
            return this.pacienteDaoInterface.selectAll();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }
}
