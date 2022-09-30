
package com.portfolio.rrosales.Interface;

import com.portfolio.rrosales.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    public List <Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona (long id);
    
    public Persona findPersona(long id);
    
    
    public boolean existsById(long id);
    
}
