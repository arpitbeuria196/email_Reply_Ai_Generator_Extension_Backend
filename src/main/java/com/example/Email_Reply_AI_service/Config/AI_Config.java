package com.example.Email_Reply_AI_service.Config;


import com.example.Email_Reply_AI_service.Model.GeminiResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "GeminiCall", url = "https://generativelanguage.googleapis.com/v1beta")
public interface AI_Config {

    @PostMapping("/models/gemini-2.5-flash:generateContent")
 GeminiResponse getReplyAI(@RequestBody JsonNode jsonNode, @RequestHeader("x-goog-api-key") String apiKey);

}
