package com.portfolio.rrosales.Controller;

import com.portfolio.rrosales.Dto.dtoProyecto;
import com.portfolio.rrosales.Entity.Proyecto;
import com.portfolio.rrosales.Security.Controller.Mensaje;
import com.portfolio.rrosales.Service.ImpProyectoService;
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
@RequestMapping("/proyectos")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class ProyectoController {

    @Autowired
    ImpProyectoService iProyectoService;

    @GetMapping("/traer")
    public ResponseEntity<List<Proyecto>> listaProyecto() {
        List<Proyecto> listaProy = iProyectoService.listaProyecto();
        return new ResponseEntity(listaProy, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") long id) {
        if (!iProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = iProyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPro) {
        if (StringUtils.isBlank(dtoPro.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (iProyectoService.existsByTitulo(dtoPro.getTitulo())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoPro.getTitulo(), dtoPro.getFecha(), dtoPro.getUrl_img(), dtoPro.getUrl_proyecto());
        iProyectoService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto agregado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoProyecto dtoPro) {
        if (!iProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        if (iProyectoService.existsByTitulo(dtoPro.getTitulo()) && iProyectoService.getByTitulo(dtoPro.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPro.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo de proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = iProyectoService.getOne(id).get();
        proyecto.setTitulo(dtoPro.getTitulo());
        proyecto.setFecha(dtoPro.getFecha());
        proyecto.setUrl_img(dtoPro.getUrl_img());
        proyecto.setUrl_proyecto(dtoPro.getUrl_proyecto());

        iProyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!iProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        iProyectoService.delete(id);
        return new ResponseEntity(new Mensaje("El proyecto fue eliminado correctamente"), HttpStatus.OK);
    }

}
