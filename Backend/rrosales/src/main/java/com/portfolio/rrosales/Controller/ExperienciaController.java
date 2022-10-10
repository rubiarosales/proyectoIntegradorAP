package com.portfolio.rrosales.Controller;

import com.portfolio.rrosales.Dto.dtoExperiencia;
import com.portfolio.rrosales.Entity.Experiencia;
import com.portfolio.rrosales.Security.Controller.Mensaje;
import com.portfolio.rrosales.Service.ImpExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class ExperienciaController {

    @Autowired
    ImpExperienciaService iExperienciaService;

    @GetMapping("/traer")
    public ResponseEntity<List<Experiencia>> listaExperiencia() {
        List<Experiencia> listaE = iExperienciaService.listaExperiencia();
        return new ResponseEntity(listaE, HttpStatus.OK);
    }
    
    
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("La empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (iExperienciaService.existsByEmpresa(dtoExp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("Esa empresa ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoExp.getCargo(), dtoExp.getEmpresa(), dtoExp.getFecha(),dtoExp.getDescripcion_cargo(), dtoExp.getUrl_logo());
        iExperienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") long id){
        if(!iExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = iExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoExperiencia dtoExp) {
        if (!iExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        if (iExperienciaService.existsByEmpresa(dtoExp.getEmpresa()) && iExperienciaService.getByEmpresa(dtoExp.getEmpresa()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("La empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = iExperienciaService.getOne(id).get();
        experiencia.setCargo(dtoExp.getCargo());
        experiencia.setEmpresa(dtoExp.getEmpresa());
        experiencia.setFecha(dtoExp.getFecha());
        experiencia.setDescripcion_cargo(dtoExp.getDescripcion_cargo());
        experiencia.setUrl_logo(dtoExp.getUrl_logo());

        iExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!iExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        iExperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("La experiencia fue eliminada correctamente"), HttpStatus.OK);
    }
}
