package it.itsvil.gestioneprogetti.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    //ci permette di settare delle informazioni sulla documentazione
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Utilizzo Swagger Per gesitone progetto")
                        .description("Swagger fornisce la descrizione dei servizi rest nel controller")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }



}
