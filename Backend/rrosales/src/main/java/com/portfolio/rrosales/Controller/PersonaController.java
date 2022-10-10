package com.portfolio.rrosales.Controller;

import com.portfolio.rrosales.Dto.dtoPersona;
import com.portfolio.rrosales.Entity.Persona;
import com.portfolio.rrosales.Security.Controller.Mensaje;
import com.portfolio.rrosales.Service.ImpPersonaService;
import java.util.List;
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
@RequestMapping("/personas")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class PersonaController {

    @Autowired
    ImpPersonaService ipersonaService;

    /*@GetMapping("/traer")
    public List<Persona> getPersona() {
        return ipersonaService.listaPersona();
    } */

    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> listaPersona() {
        List<Persona> lista = ipersonaService.listaPersona();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
   /*AUNQUE NO LO UTILIZO PREFIERO DEJARLO POR SI ACASO*/
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.save(persona);
        return "La persona fue creada correctamente";
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") long id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /*AUNQUE NO LO UTILIZO PREFIERO DEJARLO POR SI ACASO*/
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable long id) {
        ipersonaService.delete(id);
        return "La persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoPersona dtoPersona) {
        
        Persona persona = ipersonaService.getOne(id).get();
        
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setTitulo(dtoPersona.getTitulo());
        persona.setDomicilio(dtoPersona.getDomicilio());
        persona.setTelefono(dtoPersona.getTelefono());
        persona.setEmail(dtoPersona.getEmail());
        persona.setSobre_mi(dtoPersona.getSobre_mi());
        persona.setUrl_foto(dtoPersona.getUrl_foto());

        ipersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada correctamente"), HttpStatus.OK);
    }

    @GetMapping("/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.getOne((long) 1).get();

    }

}
