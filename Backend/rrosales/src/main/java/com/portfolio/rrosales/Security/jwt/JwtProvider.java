package com.portfolio.rrosales.Security.jwt;


import com.portfolio.rrosales.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;


@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    //@Value("${jwt.secret}")
   // private String secret;

    @Value("${jwt.expiration}")
    private int expiration;
   
    
    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();    
        List <String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(key)
                .compact();

    }

    public String getNombreUsuarioFromToken(String token) {

        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();

    }

    public boolean validateToken(String token) {

        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("El token ha expirado");
        } catch (IllegalArgumentException e) {
            logger.error("Token vacío");
        } catch (JwtException e) {
            logger.error("Fallo en la firma");
        }
        return false;
    }
}
