package com.example.Email_Reply_AI_service.Service;


import com.example.Email_Reply_AI_service.Config.AI_Config;
import com.example.Email_Reply_AI_service.Model.GeminiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiAIService {

    private final AI_Config aiConfig;

    private String API_KEY = "AIzaSyDX6JeHBaYouT_5LdiOHfmZMk-3hBv__s8";

    public String getReplyFromGemini(String prompt) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode request = objectMapper.readTree("""
    {
      "contents": [
        {
          "parts": [
            {
              "text": ""
            }
          ]
        }
      ]
    }
""");

        ((ObjectNode) request.at("/contents/0/parts/0")).put("text", prompt);
        GeminiResponse geminiResponse = aiConfig.getReplyAI(request,API_KEY);

        if (geminiResponse.getCandidates() == null || geminiResponse.getCandidates().isEmpty()) {
            return "No AI response received.";
        }


        return geminiResponse.getCandidates().get(0).getContent().getParts().get(0).getText();
    }
}
