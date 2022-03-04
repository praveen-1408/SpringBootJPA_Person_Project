package com.in28miniutes.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28miniutes.database.entity.Person;
import com.in28miniutes.database.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

private Logger logger = LoggerFactory.getLogger(this.getClass());

@Autowired
PersonJpaRepository repository;

public static void main(String[] args) {
SpringApplication.run(JpaDemoApplication.class, args);
}

@Override
public void run(String... args) throws Exception {


logger.info("Inserting -> {}",
repository.insert(new Person("Tara", "Berlin", new Date())));

logger.info("Inserting -> {}",
repository.insert(new Person( "Pieter", "Utrecht", new Date())));

Person person = repository.findById(1);
logger.info("Employee -> {}",person);

Person updatedPerson = repository.updatePerson(2,"Pieter", "Dubai", new Date());
logger.info("Updated Employee -> {}",updatedPerson);
//Repository.deleteBy(1);


logger.info("All users -> {}", repository.findAll());
}
} 
