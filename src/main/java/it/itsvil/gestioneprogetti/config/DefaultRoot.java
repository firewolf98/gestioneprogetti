package it.itsvil.gestioneprogetti.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultRoot implements WebMvcConfigurer {

    //quando accediamo a "/" ci reindirizza a swagger-ui.path
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/gestioneProgetti-swagger-ui.html");
    }


}
