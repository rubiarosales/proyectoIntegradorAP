
package com.portfolio.rrosales.Service;

import com.portfolio.rrosales.Entity.Persona;
import com.portfolio.rrosales.Interface.IPersonaService;
import com.portfolio.rrosales.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonarepository;
    

    @Override
    public List<Persona> getPersona() {
      List<Persona> persona = ipersonarepository.findAll();
      return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(long id) {
        Persona persona = ipersonarepository.findById(id).orElse(null);
        return persona;
    }
   
    
    @Override
        public boolean existsById(long id) {
        return ipersonarepository.existsById(id);
    }
    
  
    public boolean existsByEmail(String email) {
        return ipersonarepository.existsByEmail(email);
    }
 public Optional<Persona> getByEmail(String email) {
        return ipersonarepository.findByEmail(email);
    }

 
}