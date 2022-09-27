package com.chatting.chattingSystem.Repo;

import com.chatting.chattingSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
      List<User> findAllByStatus(String status);
      List<User> findAllByUserid(String receiverid);
}
