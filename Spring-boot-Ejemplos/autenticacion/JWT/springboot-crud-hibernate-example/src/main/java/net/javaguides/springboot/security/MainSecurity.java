package net.javaguides.springboot.security;

import net.javaguides.springboot.security.jwt.JwtEntryPoint;
import net.javaguides.springboot.security.jwt.JwtTokenFilter;
import net.javaguides.springboot.security.service.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//Anotaciones de configuracion, seguridad y activar el metodo de seguridad

//Implementacion clases de usuario
@Configuration
@EnableWebSecurity
 //Metodos para el administrador,
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter { //clase que hereda de la seguridad web configuracion
//Clase principal que organiza los datos de la seguridad

    @Autowired
    UsuarioDetailsServiceImpl userDetailsService; //Servicio implementado

    @Autowired
    JwtEntryPoint jwtEntryPoint; //Mensajes


    /*Un Bean es un componente software que tiene la particularidad de ser reutilizable y así evitar la
    tediosa tarea de programar los distintos componentes uno a uno. Se puede decir que existen con la finalidad
    de ahorrarnos tiempo al programar.*/

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {  //Codificar contraseña
        return new BCryptPasswordEncoder();
    }

    //Interesan solo los primeros metodos

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Obtiene al usuario y cifra la contraseña
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        //Autenticacion
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {

        return super.authenticationManager();
    }

    //No se maneja una cookie
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll() //Puede ser cualquier cosa para acceder, login auth, nuevo usuario, etc
                .anyRequest().authenticated() // en esto se tiene que estar autentcado
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint) // lanza error 401 no autorizado
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // que tipo de politica de sesion sin estado se posee
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // por cada petición pasa el usuario (se envia el token), lo comprueba al contexto de autenticacion
    }
}