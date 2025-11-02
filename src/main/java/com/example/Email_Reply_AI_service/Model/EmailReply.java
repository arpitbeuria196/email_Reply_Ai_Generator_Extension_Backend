package com.example.Email_Reply_AI_service.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailReply {
    private String emailContent;
    private Tone tone;
    private String reply;
}
