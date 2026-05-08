package com.scs.emailthreat.model;

import jakarta.persistence.*;

@Entity
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String result;

    private double confidence;

    public EmailEntity() {}

    public EmailEntity(String content, String result, double confidence) {
        this.content = content;
        this.result = result;
        this.confidence = confidence;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getResult() {
        return result;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
