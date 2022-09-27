package com.chatting.chattingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {

    @NotBlank (message = "Must not be blank")
    private String senderid;
    @NotBlank (message = "Must not be blank")
    private String receiverid;
    @NotBlank (message = "Must not be blank")
    private String message;
}
