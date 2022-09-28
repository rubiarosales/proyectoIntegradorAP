
package com.portfolio.rrosales.Repository;

import com.portfolio.rrosales.Entity.RedesSociales;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedesRepository extends JpaRepository<RedesSociales,Long>{
    public Optional <RedesSociales> findByNombre (String nombre);
    public boolean existsByNombre(String nombre);
}