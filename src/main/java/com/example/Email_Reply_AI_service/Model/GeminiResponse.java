package com.example.Email_Reply_AI_service.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeminiResponse {

    private List<Candidate> candidates;
    private String modelVersion;
    private String responseId;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Candidate
    {
        private Content content;
        private String finishReason;
        private int index;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content
    {
        private List<Part> parts;
        private String role;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Part
    {
        private String text;
    }

}
