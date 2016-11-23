package com.example;

import com.example.repository.resource.Book;
import com.example.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableJpaRepositories("com.example.repository")
public class BookServiceApplication {

    private Logger logger = Logger.getLogger(BookServiceApplication.class.getName());

    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "book-server");

        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeDb(BookRepository repository) {
        logger.info("Initializing database...");
        return (args) -> {
            // save a couple of books
            repository.save(new Book("Getting Started With Spring Framework", "Ashish Sarin and J Sharma"));
            repository.save(new Book("Spring Recipes: A Problem-Solution Approach", "Gary Mark, Daniel Rubio and Josh Long"));
            repository.save(new Book("Pro Spring 3", "Clarence Ho and Rob Harrop"));
        };
    }
}
