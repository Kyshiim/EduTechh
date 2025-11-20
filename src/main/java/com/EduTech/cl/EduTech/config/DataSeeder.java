package com.EduTech.cl.EduTech.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.EduTech.cl.EduTech.model.Usuario; 
import com.EduTech.cl.EduTech.repository.UsuarioRepository; 


@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner initDatabase(UsuarioRepository repo) { 
        return args -> {
            // Verifica que la tabla esté vacía para no duplicar datos en cada inicio
            if (repo.count() == 0) {
                
                // Usuario de Ejemplo 1
                Usuario u1 = new Usuario();
                u1.setRun("11.111.111-1");
                u1.setNombres("Catalina");
                u1.setApellidos("Rojas");
                u1.setCorreo("catalina.rojas@edutech.cl");
                repo.save(u1);

                // Usuario de Ejemplo 2
                Usuario u2 = new Usuario();
                u2.setRun("22.222.222-2");
                u2.setNombres("Javier");
                u2.setApellidos("Pérez");
                u2.setCorreo("javier.perez@edutech.cl");
                repo.save(u2);

                System.out.println(" Base de datos inicializada con 2 usuarios de ejemplo.");
            }
        };
    }
}