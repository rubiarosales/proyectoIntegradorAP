
package com.portfolio.rrosales.Repository;

import com.portfolio.rrosales.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Long>{
    public Optional <Educacion> findByTitulo (String titulo);
    public boolean existsByTitulo(String titulo);
}
