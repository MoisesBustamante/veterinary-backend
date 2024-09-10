package com.softcaribe.veterinary.controller;


import com.softcaribe.veterinary.business.BusinessPacienteInterface;
import com.softcaribe.veterinary.dto.CiudadesDTO;
import com.softcaribe.veterinary.dto.PacientesDTO;
import com.softcaribe.veterinary.mensajes.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/pacientes/")

public class PacienteController {
    private BusinessPacienteInterface businessPacienteInterface;
    public PacienteController(BusinessPacienteInterface businessPacienteInterface){
        this.businessPacienteInterface=businessPacienteInterface;
    }
    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<PacientesDTO>> saveOrUpdate(@RequestBody PacientesDTO request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            businessPacienteInterface.saveOrUpdate(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }


        return ResponseEntity.ok(message);
    }
    @PostMapping({"/findById"})
    public ResponseEntity<ResponseMessage<PacientesDTO>> findById(@RequestBody PacientesDTO request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
           PacientesDTO  pacientesDTO= businessPacienteInterface.findById(request);

            message = new ResponseMessage<>(200, "findById, process successful ", pacientesDTO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }
    @GetMapping("/All")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<Map<String, Object>> list = null;
        ResponseMessage message =null;


        try {
            list= this.businessPacienteInterface.selectAll();
            message = new ResponseMessage<>(200, "All, process successful ", list );
        }catch (Exception exception){
            message = new ResponseMessage<>(406, exception.getMessage(),null );
        }
        return ResponseEntity.ok(message);
    }
    @PostMapping({"/Delete"})
    public ResponseEntity<ResponseMessage<PacientesDTO>> delete(@RequestBody PacientesDTO request) {
        log.debug("REST request to Delete Persona : {}", request);
        ResponseMessage<PacientesDTO> message;

        try {
            // Llamar al servicio para eliminar la persona
            this.businessPacienteInterface.delete(request);

            // Crear un mensaje de respuesta exitoso
            message = new ResponseMessage<>(200, "Delete, process successful", request);
        } catch (DataIntegrityViolationException ex) {
            // Capturar excepciones relacionadas con la integridad referencial
            log.error("Data integrity violation: {}", ex.getMessage(), ex);
            message = new ResponseMessage<>(500, "No se puede eliminar la persona porque tiene datos relacionados.", null);
            return ResponseEntity.badRequest().body(message);
        } catch (Exception ex) {
            // Capturar cualquier otra excepción general
            log.error("Error general al eliminar la persona: {}", ex.getMessage(), ex);
            message = new ResponseMessage<>(500, "Error al procesar la solicitud", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }

        return ResponseEntity.ok(message);
    }
}
