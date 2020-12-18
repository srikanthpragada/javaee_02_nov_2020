package com.st.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"basics","web","jpa","rest"})
@EnableJpaRepositories("jpa")
@EntityScan("jpa")
public class SpringbootmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmvcApplication.class, args);
	}

}
