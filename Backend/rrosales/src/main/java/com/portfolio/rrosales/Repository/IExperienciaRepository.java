
package com.portfolio.rrosales.Repository;

import com.portfolio.rrosales.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Long> {
    public Optional <Experiencia> findByEmpresa (String empresa);
    public boolean existsByEmpresa (String empresa);
    
    
}
