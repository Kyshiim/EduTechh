package com.EduTech.cl.EduTech.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.EduTech.cl.EduTech.Model.Inscripcion;
import com.EduTech.cl.EduTech.Repository.InscripcionRepository;

import java.util.Date;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(InscripcionRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                Inscripcion i1 = new Inscripcion();
                i1.setFecha(new Date()); // fecha actual
                i1.setEstado("ACTIVA");
                repo.save(i1);

                Inscripcion i2 = new Inscripcion();
                i2.setFecha(new Date()); // otra inscripción con fecha actual
                i2.setEstado("PENDIENTE");
                repo.save(i2);
            }
        };
    }
}
