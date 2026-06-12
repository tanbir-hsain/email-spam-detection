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

            String result = "ERROR";

            if (response.getBody() != null && response.getBody().get("prediction") != null) {
                result = response.getBody().get("prediction").toString();
            }

            return new EmailResponseDTO(result, 1.0);

        } catch (Exception e) {
            return new EmailResponseDTO("ERROR", 0.0);
        }
    }
}