package com.portfolio.rrosales.Security.Repository;

import com.portfolio.rrosales.Security.Entity.Rol;
import com.portfolio.rrosales.Security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
