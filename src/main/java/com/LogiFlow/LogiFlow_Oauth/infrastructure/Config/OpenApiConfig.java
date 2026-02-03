package com.LogiFlow.LogiFlow_Oauth.infrastructure.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    // todo: Añadir
    private static  final String SECURITY_SCHEME_NAME = "";

    // Configuracion de swagger
    @Bean
    public OpenAPI customerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NutriLens API")
                        .description("API REST para la aplicación LogiFLow - Seguridad e integraciones con microservicios")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("LogiFlow team")
                                .email("*"))
                        .license(new License()
                                .name("Licencia Privada")
                                .url("https://LogiFlow.com/license")))
                .servers(List.of(
                        new Server().url("/").description("Servidor actual"),
                        new Server().url("http://localhost:8080").description("Local"),
                        new Server().url("*").description("Producción")))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Token JWT. Obtener en POST /auth/login o /auth/register e ingresar como: Bearer &lt;token&gt;")));

    }
}
