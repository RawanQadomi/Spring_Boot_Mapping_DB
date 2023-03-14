package com.seera.data.task;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testng.annotations.Test;


import java.sql.Connection;
import java.sql.SQLException;





@EnableJpaRepositories
@SpringBootApplication
public class TaskApplication {


	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}


}
