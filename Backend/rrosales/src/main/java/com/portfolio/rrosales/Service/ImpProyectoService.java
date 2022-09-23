
package com.portfolio.rrosales.Service;


import com.portfolio.rrosales.Entity.Proyecto;
import com.portfolio.rrosales.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    
     @Autowired
     IProyectoRepository iProyectoRepository;
     
      public List<Proyecto> listaProyecto() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(long id) {
        return iProyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByTitulo(String titulo) {
        return iProyectoRepository.findByTitulo(titulo);
    }

    public void save(Proyecto titulo) {
        iProyectoRepository.save(titulo);
    }

    public void delete(long id) {
        iProyectoRepository.deleteById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return iProyectoRepository.existsByTitulo(titulo);
    }

    public boolean existsById(long id) {
        return iProyectoRepository.existsById(id);
    }
}
