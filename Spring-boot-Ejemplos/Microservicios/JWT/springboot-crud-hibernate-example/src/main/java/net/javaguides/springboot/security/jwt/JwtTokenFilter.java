package net.javaguides.springboot.security.jwt;


import net.javaguides.springboot.security.service.UsuarioDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Comprueba que el token sea valido y genera las excepciones
//Se ejecuta una vez por cada  peticion, siempre verificara el token
public class JwtTokenFilter extends OncePerRequestFilter {


    //Por cada req, se ejecuta
    /* lo que hace es comprobar que el token, y usa al provider, en caso de que este valido da los privilegios */

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UsuarioDetailsServiceImpl userDetailsService;

    @Override
    // Metodo de autenticación, comprueba el token
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            //Obtener el token
            String token = getToken(req);
            //Si token no es nulo y esta validado
            if (token != null && jwtProvider.validateToken(token)) {
                //Obtiene el nombre de usuario y los detalles del usuario
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                    // Se crea una nueva autenticacion y obtiene las autorizaciones para los recursos
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //Al contexto de autenticacion se le asigna el usuario
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error("Falla en el metodo de filtro " + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    // Obtener el token, quitar el bearer y el espacio
    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer"))
            //Reemplazar cadena de bearer por una cadena de longitud cero
            return header.replace("Bearer ", "");
        return null;
    }

}
