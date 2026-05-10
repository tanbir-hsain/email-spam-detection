package com.scs.emailthreat.service;

import com.scs.emailthreat.dto.EmailResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Value("${flask.api.url}")
    private String flaskUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public EmailResponseDTO analyze(String content) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> entity =
                    new HttpEntity<>(Map.of("emailText", content), headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(flaskUrl, entity, Map.class);

            String result = (response.getBody() != null)
                    ? String.valueOf(response.getBody().get("prediction"))
                    : "ERROR";

            return new EmailResponseDTO(result, 0.0);

        } catch (Exception e) {
            logger.error("Flask error: {}", e.getMessage());
            return new EmailResponseDTO("ERROR", 0.0);
        }
    }
}