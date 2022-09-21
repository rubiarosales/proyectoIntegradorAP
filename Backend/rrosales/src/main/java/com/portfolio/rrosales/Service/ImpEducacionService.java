
package com.portfolio.rrosales.Service;

import com.portfolio.rrosales.Entity.Educacion;
import com.portfolio.rrosales.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    
    @Autowired
    IEducacionRepository iEducacionRepository;
    
        public List <Educacion> listaEducacion(){
        return iEducacionRepository.findAll();
    }
    
    
    public Optional<Educacion> getOne(long id) {
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByTitulo (String titulo) {
        return iEducacionRepository.findByTitulo(titulo);
    }
    
 
    public void save(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }
    
    public void delete(long id) {
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsByTitulo(String titulo) {
        return iEducacionRepository.existsByTitulo(titulo);
    }
    
    public boolean existsById(long id) {
        return iEducacionRepository.existsById(id);
    }
    
    
    
}
