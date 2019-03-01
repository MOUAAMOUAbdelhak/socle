package app.socleapp;

import app.restcontroller.CandidatRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Import(SwaggerConfig.class)
@EntityScan("app.entities")
@Configuration
@ComponentScan("app.restcontroller")
@SpringBootApplication
//@EnableAutoConfiguration

public class SocleappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocleappApplication.class, args);


    }

}
