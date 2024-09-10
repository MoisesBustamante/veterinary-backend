package com.softcaribe.veterinary.manager;

import com.softcaribe.veterinary.dao.CiudadDaoInterface;
import com.softcaribe.veterinary.dao.PropietarioDaoInterface;
import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.PropietariosDTO;
import com.softcaribe.veterinary.exceptions.DaoExceptions;
import com.softcaribe.veterinary.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ManagerPropietarioImplements implements  ManagerPropietarioInterface{
    public PropietarioDaoInterface propietarioDaoInterface;
    public ManagerPropietarioImplements(PropietarioDaoInterface propietarioDaoInterface){
        this.propietarioDaoInterface=propietarioDaoInterface;
    }
    @Override
    public void saveOrUpdate(PropietariosDTO propietariosDTO) throws ManagerExceptions {
        try {
            PropietariosDTO propietariosFound = this.propietarioDaoInterface.findById(propietariosDTO);
            if (propietariosFound==null){
                this.propietarioDaoInterface.insert(propietariosDTO);
            }else{
                this.propietarioDaoInterface.update(propietariosDTO);
            }
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public PropietariosDTO findById(PropietariosDTO propietariosDTO) throws ManagerExceptions {
        PropietariosDTO propietariosFound= null;
        try {
           propietariosFound= this.propietarioDaoInterface.findById(propietariosDTO);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return propietariosFound;
    }

    @Override
    public void delete(PropietariosDTO propietariosDTO) throws ManagerExceptions {
        try {
            this.propietarioDaoInterface.delete(propietariosDTO);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerExceptions {
        try {
            return this.propietarioDaoInterface.selectAll();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }
}
