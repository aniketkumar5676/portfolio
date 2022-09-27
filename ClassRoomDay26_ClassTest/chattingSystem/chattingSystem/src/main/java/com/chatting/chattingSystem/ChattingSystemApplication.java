package com.chatting.chattingSystem;

import com.chatting.chattingSystem.Entity.UserCredentials;
import com.chatting.chattingSystem.Repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ChattingSystemApplication {

	@Autowired
	UserCredentialsRepo userCredentialsRepo;

	@PostConstruct
	public void pushingCredentials(){

		List<UserCredentials> userCredentialsList = Stream.of(new UserCredentials(1,"Aniket","aniket"),
				                                              new UserCredentials(2,"Satyajeet","satyajeet"))
				                                              .collect(Collectors.toList());
		userCredentialsRepo.saveAll(userCredentialsList);

	}

	public static void main(String[] args) {
		SpringApplication.run(ChattingSystemApplication.class, args);
	}

}
