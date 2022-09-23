
package com.portfolio.rrosales.Repository;


import com.portfolio.rrosales.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto,Long>{
    public Optional <Proyecto> findByTitulo (String titulo);
    public boolean existsByTitulo(String titulo);
    
}
