package com.chatting.chattingSystem.Repo;

import com.chatting.chattingSystem.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {
    UserCredentials findByUsername(String username);
}
