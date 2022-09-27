package com.chatting.chattingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {
    @NotBlank(message = "Must not be blank")
    private String username;
    @NotBlank (message = "Must not be blank")
    private String password;

}
