package com.EduTech.cl.EduTech.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.repository.CursoRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(CursoRepository repo) {
        return args -> {
            if (!repo.findAll().iterator().hasNext()) {
                Curso c1 = new Curso();
                c1.setTitulo("Spring Boot desde cero");
                c1.setDescripcion("Curso completo para aprender Spring Boot paso a paso");
                c1.setCategoria("Backend");
                c1.setEstado("DISPONIBLE");
                repo.guardar(c1);

                Curso c2 = new Curso();
                c2.setTitulo("Java Avanzado");
                c2.setDescripcion("Conceptos avanzados de Java para aplicaciones empresariales");
                c2.setCategoria("Programación");
                c2.setEstado("DISPONIBLE");
                repo.guardar(c2);

                Curso c3 = new Curso();
                c3.setTitulo("Docker y Microservicios");
                c3.setDescripcion("Orquestación de contenedores y despliegue en la nube");
                c3.setCategoria("DevOps");
                c3.setEstado("PENDIENTE");
                repo.guardar(c3);
            }
        };
    }
}
