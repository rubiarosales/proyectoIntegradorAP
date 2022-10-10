
package com.portfolio.rrosales.Controller;

import com.portfolio.rrosales.Dto.dtoRedes;
import com.portfolio.rrosales.Entity.RedesSociales;
import com.portfolio.rrosales.Security.Controller.Mensaje;
import com.portfolio.rrosales.Service.ImpRedesService;
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
@RequestMapping("/redes")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class RedesController {
    
@Autowired
    ImpRedesService iRedesService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<RedesSociales>> listaRedes() {
        List<RedesSociales> listaHab = iRedesService.listaRedes();
        return new ResponseEntity(listaHab, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoRedes dtoRedes) {
        if (StringUtils.isBlank(dtoRedes.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la red es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (iRedesService.existsByNombre(dtoRedes.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa red ya existe"), HttpStatus.BAD_REQUEST);
        }
        RedesSociales redes = new RedesSociales(dtoRedes.getNombre(), dtoRedes.getUrl_red(),dtoRedes.getUrl_logo());
        iRedesService.save(redes);
        
        return new ResponseEntity(new Mensaje("Red social agregada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoRedes dtoRedes) {
        if (!iRedesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        if (iRedesService.existsByNombre(dtoRedes.getNombre()) && iRedesService.getByNombre(dtoRedes.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoRedes.getNombre())) {
            return new ResponseEntity(new Mensaje("El titulo de proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        RedesSociales redes = iRedesService.getOne(id).get();
        redes.setNombre(dtoRedes.getNombre());
        redes.setUrl_red(dtoRedes.getUrl_red());
        redes.setUrl_logo(dtoRedes.getUrl_logo());
                
        iRedesService.save(redes);
        return new ResponseEntity(new Mensaje("Red Social actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!iRedesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        iRedesService.delete(id);
        return new ResponseEntity(new Mensaje("La red social fue eliminado correctamente"), HttpStatus.OK);
    }    
    
}
