package com.spring_boot_jpa.Spring.Boot.JPA;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringBootJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
		log.info("JPA Application Started!!!");
	}

}
