package com.scs.emailthreat.service;

import com.scs.emailthreat.dto.EmailResponseDTO;
import com.scs.emailthreat.model.EmailEntity;
import com.scs.emailthreat.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailAnalysisService {

    @Autowired
    private EmailRepository repository;

    public EmailResponseDTO analyzeEmail(String content) {
        try {
            String url = "http://localhost:5000/predict";

            RestTemplate restTemplate = new RestTemplate();

            Map<String, String> request = new HashMap<>();
            request.put("emailText", content);

            Map<String, Object> response =
                    restTemplate.postForObject(url, request, Map.class);

            String result = response.get("prediction").toString();

            double confidence = 0.0;
            if (response.get("confidence") != null) {
                confidence = Double.parseDouble(response.get("confidence").toString());
            }

            EmailEntity email = new EmailEntity();
            email.setContent(content);
            email.setResult(result);
            email.setConfidence(confidence);

            repository.save(email);

            return new EmailResponseDTO(result, confidence);

        } catch (Exception e) {
            e.printStackTrace();
            return new EmailResponseDTO("ERROR", 0.0);
        }
    }
}