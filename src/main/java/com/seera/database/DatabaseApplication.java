package com.seera.database;

import com.seera.database.entity.L1_Services;
import com.seera.database.entity.L2_Services;
import com.seera.database.repository.ExpectedServiceRepo;
import com.seera.database.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories
@SpringBootApplication
public class DatabaseApplication {


	private static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ctx = SpringApplication.run(DatabaseApplication.class, args);
		int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				// no errors
				return 0;
			}
		});
		System.exit(exitCode);
	}
}
