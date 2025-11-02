package com.example.Email_Reply_AI_service.Controller;


import com.example.Email_Reply_AI_service.Model.EmailReply;
import com.example.Email_Reply_AI_service.Model.Tone;
import com.example.Email_Reply_AI_service.Service.GeminiAIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
//@RequestMapping("/api/aiReply")
@RequiredArgsConstructor
public class GeminiAIController {

    private final GeminiAIService geminiAIService;

//    @PostMapping
//    public String getAIReply(@RequestBody EmailReply emailReply) throws JsonProcessingException {
//
//       return geminiAIService.getReplyFromGemini(emailReply.getEmailContent()+"With"+emailReply.getTone());
//    }

    @MutationMapping
    public EmailReply getAIReply(@Argument String emailContent, @Argument Tone tone) throws JsonProcessingException {
        String prompt = tone + ": " + emailContent;
        String reply = geminiAIService.getReplyFromGemini(prompt);
        return new EmailReply(emailContent, tone, reply);

    }
}
