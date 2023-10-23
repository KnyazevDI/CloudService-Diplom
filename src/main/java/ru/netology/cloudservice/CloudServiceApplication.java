package ru.netology.cloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"ru.netology.cloudservice.*"})
@EntityScan( basePackages = {"ru.netology.cloudservice.*"} )
@EnableJpaRepositories( basePackages = {"ru.netology.cloudservice.*"} )
public class CloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceApplication.class, args);
    }

}
