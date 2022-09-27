package com.chatting.chattingSystem.Repo;

import com.chatting.chattingSystem.Entity.UserChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChatHistoryRepo extends JpaRepository<UserChatHistory,Integer> {
    List<UserChatHistory> findAllBySenderid(String senderid);
}
