package com.portfolio.rrosales.Repository;

import com.portfolio.rrosales.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    public Optional<Persona> findByEmail(String email);

    public boolean existsByEmail(String email);
}
