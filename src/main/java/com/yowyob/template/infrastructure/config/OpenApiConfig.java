package com.yowyob.template.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server; // Import ajouté
import org.springframework.beans.factory.annotation.Value; // Import ajouté
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

  // Injection de l'URL de production avec la valeur par défaut
  @Value("${app.swagger.server-url}")
  private String serverUrl;

  @Bean
  public OpenAPI customOpenAPI() {
    final String securitySchemeName = "bearerAuth";

    return new OpenAPI()
            .info(new Info()
                    .title("YowYob Microservice Payment - API")
                    .version("1.0.0")
                    .description("Documentation de l'API Payment pour la gestion des Wallets et Transactions.")
                    .contact(new Contact()
                            .name("Équipe Backend")
                            .email("dev@yowyob.com"))
                    .license(new License()
                            .name("Apache 2.0")
                            .url("http://springdoc.org")))
            // Ajout de la configuration des serveurs
            .servers(List.of(
                    new Server().url(serverUrl).description("Serveur de Production / Proxy"),
                    new Server().url("/").description("Serveur Local")
            ))
            .components(new Components()
                    .addSecuritySchemes(securitySchemeName,
                            new SecurityScheme()
                                    .name(securitySchemeName)
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")))
            .addSecurityItem(new SecurityRequirement().addList(securitySchemeName));
  }
}