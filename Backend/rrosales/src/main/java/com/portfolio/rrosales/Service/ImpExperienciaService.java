package com.portfolio.rrosales.Service;

import com.portfolio.rrosales.Entity.Experiencia;
import com.portfolio.rrosales.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
    
    @Autowired
    IExperienciaRepository iExperienciaRepository;
    
    public List <Experiencia> listaExperiencia(){
        return iExperienciaRepository.findAll();
    }
    
    
    public Optional<Experiencia> getOne(long id) {
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByEmpresa(String empresa) {
        return iExperienciaRepository.findByEmpresa(empresa);
    }
    
 
    public void save(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }
    
    public void delete(long id) {
        iExperienciaRepository.deleteById(id);
    }
    
    public boolean existsByEmpresa(String empresa) {
        return iExperienciaRepository.existsByEmpresa(empresa);
    }
    
    public boolean existsById(long id) {
        return iExperienciaRepository.existsById(id);
    }
    
       
}
