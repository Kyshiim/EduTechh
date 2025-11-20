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
                // Usuario de Ejemplo 3
                Usuario u3 = new Usuario();
                u3.setRun("33.333.333-3");
                u3.setNombres("Ronald");
                u3.setApellidos("Mcdonald");
                u3.setCorreo("ronald.mcdonalds@edutech.cl");
                repo.save(u3);
                //Usuario de Ejemplo 4
                Usuario u4 = new Usuario();
                u4.setRun("44.444.444-4");
                u4.setNombres("Jhin");
                u4.setApellidos("Khada");
                u4.setCorreo("Jhin4khada@sublime.cl");
                repo.save(u4);
                
                System.out.println(" Base de datos inicializada con 4 usuarios de ejemplo.");
            }
        };
    }
}