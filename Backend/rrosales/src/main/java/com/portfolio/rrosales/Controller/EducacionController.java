
package com.portfolio.rrosales.Controller;

import com.portfolio.rrosales.Dto.dtoEducacion;
import com.portfolio.rrosales.Entity.Educacion;
import com.portfolio.rrosales.Security.Controller.Mensaje;
import com.portfolio.rrosales.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class EducacionController {
    
    @Autowired
    ImpEducacionService iEducacionService;

    @GetMapping("/traer")
    public ResponseEntity<List<Educacion>> listaEducacion() {
        List<Educacion> listaEdu = iEducacionService.listaEducacion();
        return new ResponseEntity(listaEdu, HttpStatus.OK);
    }
    
       @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") long id){
        if(!iEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = iEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (iEducacionService.existsByTitulo(dtoEdu.getTitulo())) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoEdu.getInstitucion(), dtoEdu.getTitulo(), dtoEdu.getFecha(),dtoEdu.getUrl_logo());
        iEducacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoEducacion dtoEdu) {
        if (!iEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        if (iEducacionService.existsByTitulo(dtoEdu.getTitulo()) && iEducacionService.getByTitulo(dtoEdu.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEdu.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = iEducacionService.getOne(id).get();
        educacion.setTitulo(dtoEdu.getTitulo());
        educacion.setInstitucion(dtoEdu.getInstitucion());
        educacion.setFecha(dtoEdu.getFecha());
        educacion.setUrl_logo(dtoEdu.getUrl_logo());

        iEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!iEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        iEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("La educacion fue eliminada correctamente"), HttpStatus.OK);
    }  
    
}
