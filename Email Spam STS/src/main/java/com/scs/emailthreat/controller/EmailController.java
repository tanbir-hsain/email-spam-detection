
package com.scs.emailthreat.controller;

import com.scs.emailthreat.dto.EmailResponseDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {

    @PostMapping("/analyze")
    public EmailResponseDTO checkSpam(@RequestBody Map<String, Object> request) {

        // 🔥 Accept BOTH formats
        String content = null;

        if (request.get("content") != null) {
            content = request.get("content").toString();
        } else if (request.get("emailText") != null) {
            content = request.get("emailText").toString();
        }

        System.out.println("CONTENT: " + content);

        // ❌ Handle null safely
        if (content == null || content.trim().isEmpty()) {
            return new EmailResponseDTO("ERROR", 0.0);
        }

        String url = "http://localhost:5000/predict";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> body = new HashMap<>();
        body.put("emailText", content);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> responseEntity =
                restTemplate.postForEntity(url, entity, Map.class);

        Map response = responseEntity.getBody();

        String result = "ERROR";

        if (response != null && response.get("prediction") != null) {
            result = response.get("prediction").toString();
        }

        return new EmailResponseDTO(result, 0.0);
    }
}