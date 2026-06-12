package com.scs.emailthreat.dto;

public class EmailResponseDTO {

    private String result;
    private double confidence;

    public EmailResponseDTO(String result, double confidence) {
        this.result = result;
        this.confidence = confidence;
    }

    public String getResult() {
        return result;
    }

    public double getConfidence() {
        return confidence;
    }
}