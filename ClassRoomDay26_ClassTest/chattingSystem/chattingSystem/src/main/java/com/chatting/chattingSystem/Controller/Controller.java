package com.chatting.chattingSystem.Controller;

import com.chatting.chattingSystem.Entity.User;
import com.chatting.chattingSystem.Entity.UserChatHistory;
import com.chatting.chattingSystem.ExceptionHandler.UserNotFound;
import com.chatting.chattingSystem.Service.ChatService;
import com.chatting.chattingSystem.Util.JwtUtil;
import com.chatting.chattingSystem.dto.AddUser;
import com.chatting.chattingSystem.dto.UserInput;
import com.chatting.chattingSystem.dto.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("fastMessage")
public class Controller {

    @Autowired
    ChatService chatService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;


    //Authenticate
    @PostMapping("/authenticate")
      public String generateToken(@RequestBody UserInput userInput) throws Exception {
        // validations
      try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInput.getUsername(), userInput.getPassword()));
        }
        catch (Exception e) {
            throw new UserNotFound("Invalid username and password");
        }
        return jwtUtil.generateToken(userInput.getUsername());

    }


    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody @Valid UserMessage userMessage){
        return chatService.sendMessage(userMessage);
    }

    @GetMapping("/findMessage/{senderid}")
    public ResponseEntity<List<UserChatHistory>> findMessage(@PathVariable String senderid) throws UserNotFound {
        return ResponseEntity.ok(chatService.findMessage(senderid));
    }


    @GetMapping("/findStatus/{status}")
    public ResponseEntity<List<User>> findStatus(@PathVariable String status) throws UserNotFound {
        return ResponseEntity.ok(chatService.findStatus(status));
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid AddUser user){
        return chatService.addUser(user);
    }



}
