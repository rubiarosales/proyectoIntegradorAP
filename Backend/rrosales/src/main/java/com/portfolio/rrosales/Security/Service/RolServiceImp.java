package com.portfolio.rrosales.Security.Service;

import com.portfolio.rrosales.Security.Entity.Rol;
import com.portfolio.rrosales.Security.Repository.RolRepository;
import com.portfolio.rrosales.Security.enums.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServiceImp {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
