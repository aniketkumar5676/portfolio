package com.catalog.catalog;

import com.catalog.catalog.Entity.UserCredentials;
import com.catalog.catalog.Repo.UserCredRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication

public class CatalogApplication {

	@Autowired
	UserCredRepo userCredRepo;


	@PostConstruct
	public void users(){

		List<UserCredentials> userCredentialsList = Stream.of(
						new UserCredentials(1, "Aniket", 99900),
						new UserCredentials(2, "Rahul", 19500),
						new UserCredentials(3, "Satyajeet", 120))
				.collect(Collectors.toList());

		userCredRepo.saveAll(userCredentialsList);



	}

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



}
