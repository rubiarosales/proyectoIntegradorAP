
package com.portfolio.rrosales.Service;


import com.portfolio.rrosales.Entity.RedesSociales;
import com.portfolio.rrosales.Repository.IRedesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpRedesService {
    
     @Autowired
     IRedesRepository iRedesRepository;
     
           public List<RedesSociales> listaRedes() {
        return iRedesRepository.findAll();
    }

    public Optional<RedesSociales> getOne(long id) {
        return iRedesRepository.findById(id);
    }

    public Optional<RedesSociales> getByNombre(String nombre) {
        return iRedesRepository.findByNombre(nombre);
    }

    public void save(RedesSociales titulo) {
        iRedesRepository.save(titulo);
    }

    public void delete(long id) {
        iRedesRepository.deleteById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iRedesRepository.existsByNombre(nombre);
    }

    public boolean existsById(long id) {
        return iRedesRepository.existsById(id);
    }
    
}
