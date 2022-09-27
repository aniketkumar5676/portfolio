package com.chatting.chattingSystem.Service;

import com.chatting.chattingSystem.Entity.User;
import com.chatting.chattingSystem.Entity.UserChatHistory;
import com.chatting.chattingSystem.Entity.UserCredentials;
import com.chatting.chattingSystem.ExceptionHandler.UserNotFound;
import com.chatting.chattingSystem.Repo.UserChatHistoryRepo;
import com.chatting.chattingSystem.Repo.UserCredentialsRepo;
import com.chatting.chattingSystem.Repo.UserRepo;
import com.chatting.chattingSystem.dto.AddUser;
import com.chatting.chattingSystem.dto.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@Service
@Profile({"local"})
public class ChatService implements UserDetailsService {


    @Autowired
    UserChatHistoryRepo userChatHistoryRepo;

    @Autowired
    UserCredentialsRepo userCredentialsRepo;

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsRepo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(userCredentials.getUsername(),userCredentials.getPassword(), Collections
                .emptyList());
    }


    public String sendMessage(UserMessage userMessage) {

        String DateNow=String.valueOf(LocalDate.now());
        UserChatHistory userChatHistory = UserChatHistory.build(1, userMessage.getSenderid(),userMessage.getReceiverid(),
                                        userMessage.getMessage(),DateNow);
        userChatHistoryRepo.save(userChatHistory);

        List<User> receiverCheck = userRepo.findAllByUserid(userMessage.getReceiverid());
        List<User> senderCheck = userRepo.findAllByUserid(userMessage.getSenderid());


        if(receiverCheck.size()>0){

        }else{
            User userList = new User(1, userMessage.getReceiverid(), new Random().nextBoolean() ? "Online" : "Offline");
            userRepo.save(userList);
        }

        if(senderCheck.size()>0){

        }else{
            User userList = new User(1, userMessage.getSenderid(), new Random().nextBoolean() ? "Online" : "Offline");
            userRepo.save(userList);
        }

        return "Message Sent Successfully to " + userMessage.getReceiverid() + " at " +DateNow;

    }

    public List<UserChatHistory> findMessage(String senderid) throws UserNotFound {

        List<UserChatHistory> userList = userChatHistoryRepo.findAllBySenderid(senderid);

        if (userList.size()<1)
        {
            throw new UserNotFound("No User Found");

        }

        return userList;
    }


    public List<User> findStatus(String status) throws UserNotFound {
        List<User> userList = userRepo.findAllByStatus(status);
        if (userList.size()<1)
        {
            throw new UserNotFound("Enter Correct Status either `Online` or `Offline`");

        }

        return userList;
    }


    public String addUser(AddUser user) {

        List<User> userFind =  userRepo.findAllByUserid(user.getUserid());

        if(userFind.size()==0){
            User adduser = new User(1,user.getUserid(),new Random().nextBoolean()?"Online":"Offline");
            userRepo.save(adduser);
        }else{

            return "User "+user.getUserid() +" Already Available in Record";
        }

        return "User added Successfully";
    }
}


