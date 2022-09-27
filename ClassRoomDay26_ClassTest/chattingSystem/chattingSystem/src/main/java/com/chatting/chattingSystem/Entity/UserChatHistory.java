package com.chatting.chattingSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserChatHistory {

    @Id @GeneratedValue
    private int chatNo;
    private String senderid;
    private String receiverid;
    private String message;
    private String date;


}
