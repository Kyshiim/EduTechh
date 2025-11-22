package com.EduTech.cl.EduTech.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI cursoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EduTech API - Cursos")
                        .description("API REST para gestión de cursos en la plataforma EduTech")
                        .version("v1")
                        .contact(new Contact()
                                .name("Equipo EduTech")
                                .email("equipo@edutech.cl"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio / Documentación adicional")
                        .url("https://github.com/tu-org/edutech"));
    }
}

