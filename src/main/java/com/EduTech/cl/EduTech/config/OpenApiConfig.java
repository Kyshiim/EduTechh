package com.EduTech.cl.EduTech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("EduTech API - Gestión de Cursos")
                .version("1.0.0")
                .description("API REST para la gestión de estudiantes y cursos en la plataforma EduTech.")
                .termsOfService("http://www.edutech.cl/terminos")
                // Puedes agregar un objeto Contact o License si lo deseas
            );
    }
}