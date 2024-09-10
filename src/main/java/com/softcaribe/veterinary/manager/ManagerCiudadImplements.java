package com.softcaribe.veterinary.manager;

import com.softcaribe.veterinary.dao.CiudadDaoInterface;
import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component

public class ManagerCiudadImplements implements  ManagerCiudadInterface {
    public CiudadDaoInterface  ciudadDaoInterface;
    public ManagerCiudadImplements(CiudadDaoInterface ciudadDaoInterface){
        this.ciudadDaoInterface=ciudadDaoInterface;
    }

    @Override
    public void saveOrUpdate(CiudadesDTO ciudadesDTO)throws ManagerExceptions {
        try {
            CiudadesDTO  ciudadesFound = this.ciudadDaoInterface.findById(ciudadesDTO);
            if (ciudadesFound==null){
                this.ciudadDaoInterface.insert(ciudadesDTO);
            }else{
                this.ciudadDaoInterface.update(ciudadesDTO);
            }
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public CiudadesDTO findById(CiudadesDTO ciudadesDTO) throws ManagerExceptions{
        CiudadesDTO ciudadesFound= null;
        try {
            ciudadesFound= this.ciudadDaoInterface.findById(ciudadesDTO);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return ciudadesFound;
    }

    @Override
    public void delete(CiudadesDTO ciudadesDTO)  throws ManagerExceptions{
        try {
            this.ciudadDaoInterface.delete(ciudadesDTO);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public List<Map<String, Object>> selectAll()  throws ManagerExceptions{
        try {
            return this.ciudadDaoInterface.selectAll();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }
}
