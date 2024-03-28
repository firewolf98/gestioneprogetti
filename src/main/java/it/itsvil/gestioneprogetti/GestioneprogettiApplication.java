package it.itsvil.gestioneprogetti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestioneprogettiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestioneprogettiApplication.class, args);
    }

}
