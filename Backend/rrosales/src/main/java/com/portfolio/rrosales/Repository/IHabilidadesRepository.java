
package com.portfolio.rrosales.Repository;

import com.portfolio.rrosales.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadesRepository extends JpaRepository<Habilidades,Long>{
    public Optional <Habilidades> findByHabilidad (String habilidad);
    public boolean existsByHabilidad(String habilidad);
}
