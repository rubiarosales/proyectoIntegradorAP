
package com.portfolio.rrosales.Controller;

import com.portfolio.rrosales.Dto.dtoHabilidades;
import com.portfolio.rrosales.Entity.Habilidades;
import com.portfolio.rrosales.Security.Controller.Mensaje;
import com.portfolio.rrosales.Service.ImpHabilidadesService;
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
@RequestMapping("/habilidades")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class HabilidadesController {
 
    
   @Autowired
   ImpHabilidadesService iHabilidadesService;
   
    @GetMapping("/traer")
    public ResponseEntity<List<Habilidades>> listaHabilidades() {
        List<Habilidades> listaHab = iHabilidadesService.listaHabilidades();
        return new ResponseEntity(listaHab, HttpStatus.OK);
    }
    
       @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") long id){
        if(!iHabilidadesService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.NOT_FOUND);
        Habilidades habilidades = iHabilidadesService.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtoHab) {
        if (StringUtils.isBlank(dtoHab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (iHabilidadesService.existsByHabilidad(dtoHab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        Habilidades habilidad = new Habilidades (dtoHab.getHabilidad(), dtoHab.getNivel());
        iHabilidadesService.save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad agregada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> uptade(@PathVariable("id") long id, @RequestBody dtoHabilidades dtoHab) {
        if (!iHabilidadesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        if (iHabilidadesService.existsByHabilidad(dtoHab.getHabilidad()) && iHabilidadesService.getByHabilidad(dtoHab.getHabilidad()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoHab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("La habilidad es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidad = iHabilidadesService.getOne(id).get();
        habilidad.setHabilidad(dtoHab.getHabilidad());
        habilidad.setNivel(dtoHab.getNivel());
      

        iHabilidadesService.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!iHabilidadesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        iHabilidadesService.delete(id);
        return new ResponseEntity(new Mensaje("La habilidad fue eliminada correctamente"), HttpStatus.OK);
    }  
   
    
    
    
}
