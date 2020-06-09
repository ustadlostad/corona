package com.project.corona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class} )
public class CoronaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoronaApplication.class, args);
    }

}
