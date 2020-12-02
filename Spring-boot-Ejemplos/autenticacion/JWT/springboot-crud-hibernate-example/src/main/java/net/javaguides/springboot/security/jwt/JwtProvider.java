package net.javaguides.springboot.security.jwt;

import io.jsonwebtoken.*;
import net.javaguides.springboot.security.entity.UsuarioPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    // Genera el token y un metodo de validacion
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    //Usar variables de entorno
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;


    //Crear token
    public String generateToken(Authentication authentication) {
        //Implementar desde el usuario principal la autenticación (CLASE GENERICA)
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        //contruir el token
        /* construir el JWT pasando el usuario principal, con su nombre de usuario, Colocar la fecha de creación, colocar la expiración que sera una fecha  sumada la expiracion * 1000 osea tiempo actual mas la expiracion, se firma el token un aloritmo HS512 y en conjunto con la clave secreta */
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    //nombre de usuario
    public String getNombreUsuarioFromToken(String token) {
        //Obtener el usuario del token (getSubject es el nombre del usuario)
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    //boolena validador token
    public boolean validateToken(String token) {
        //Crear varias excepciones
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            //Si es valido el token
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacío");
        } catch (SignatureException e) {
            logger.error("Falla en la firma del token");
        }
        // No se pudo validar el token
        return false;
    }
}


