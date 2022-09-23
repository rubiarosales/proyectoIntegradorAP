package com.portfolio.rrosales.Service;

import com.portfolio.rrosales.Entity.Habilidades;
import com.portfolio.rrosales.Repository.IHabilidadesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHabilidadesService {

    @Autowired
    IHabilidadesRepository iHabilidadesRepository;

    public List<Habilidades> listaHabilidades() {
        return iHabilidadesRepository.findAll();
    }

    public Optional<Habilidades> getOne(long id) {
        return iHabilidadesRepository.findById(id);
    }

    public Optional<Habilidades> getByHabilidad(String habilidad) {
        return iHabilidadesRepository.findByHabilidad(habilidad);
    }

    public void save(Habilidades habilidad) {
        iHabilidadesRepository.save(habilidad);
    }

    public void delete(long id) {
        iHabilidadesRepository.deleteById(id);
    }

    public boolean existsByHabilidad(String habilidad) {
        return iHabilidadesRepository.existsByHabilidad(habilidad);
    }

    public boolean existsById(long id) {
        return iHabilidadesRepository.existsById(id);
    }

}
