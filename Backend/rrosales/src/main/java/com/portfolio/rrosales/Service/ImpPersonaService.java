
package com.portfolio.rrosales.Service;

import com.portfolio.rrosales.Entity.Persona;
import com.portfolio.rrosales.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {
    @Autowired
    IPersonaRepository iPersonaRepository;
    
    public List <Persona> listaPersona(){
        return iPersonaRepository.findAll();
    }
    
    
    public Optional<Persona> getOne(long id) {
        return iPersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByEmail(String email) {
        return iPersonaRepository.findByEmail(email);
    }
    
 
    public void save(Persona persona) {
        iPersonaRepository.save(persona);
    }
    
    public void delete(long id) {
        iPersonaRepository.deleteById(id);
    }
    
    public boolean existsByEmail(String email) {
        return iPersonaRepository.existsByEmail(email);
    }
    
    public boolean existsById(long id) {
        return iPersonaRepository.existsById(id);
    }
    

 
}