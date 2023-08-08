package com.springbootexample.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *  * @EnableJpaRepositories and @EntityScan are basicallly setting up your ORM, and assentially
 * several lines of code that would have to be written by us.
 *
 * Example.) I want to find a Task by it's "title". All I need to do is go to the TaskRepository
 *          and create a method called "findByTitle(String title)". In the background, Hibernate (ORM)
 *          is doing lots of things, but most importantly it is writing SQL for us equivilent to:
 *          "SELECT * FROM Task WHERE title = 'some title'".
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.*") // Allow Java Persistance API (Hibernate) on any of our @Repository within the "com/ *
@EntityScan("com.*") // Any ORM (Object Relational Model) marked with @Entity will be auto configured and scanned from hibernate
@ComponentScan(basePackages="com.*") // Sands anything with the @Component annotation
public class JpaConfig {
    // You can add additional JPA-related configuration here if needed
}

