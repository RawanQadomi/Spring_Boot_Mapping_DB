package com.seera.database;

import com.seera.database.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@EnableJpaRepositories
@SpringBootApplication
public class DatabaseApplication {


	@Autowired
	ServiceRepo serviceRepo;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}



	@PostConstruct
	private void test(){
		System.out.printf("hi");
		 serviceRepo.findAll().forEach(System.out::println);
	}

}
