package com.portfolio.rrosales.Security.Controller;

import com.portfolio.rrosales.Security.Dto.LoginUsuario;
import com.portfolio.rrosales.Security.Dto.NuevoUsuario;
import com.portfolio.rrosales.Security.Dto.JwtDto;
import com.portfolio.rrosales.Security.Entity.Rol;
import com.portfolio.rrosales.Security.Entity.Usuario;
import com.portfolio.rrosales.Security.Service.RolServiceImp;
import com.portfolio.rrosales.Security.Service.UsuarioServiceImp;
import com.portfolio.rrosales.Security.enums.RolNombre;
import com.portfolio.rrosales.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioServiceImp usuarioService;
    
    @Autowired
    RolServiceImp rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
        @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Los datos ingresados no son válidos"), HttpStatus.BAD_REQUEST);
        
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Ya existe un usuario con ese nombre"), HttpStatus.BAD_REQUEST);
        
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) 
            return new ResponseEntity(new Mensaje("El email ya está registrado"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario
                = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario registrado exitosamente"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Verifique los datos ingresados"), HttpStatus.BAD_REQUEST);
       
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
        
    }
}
