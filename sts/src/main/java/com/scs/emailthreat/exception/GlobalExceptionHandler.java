package com.scs.emailthreat.exception;

import com.scs.emailthreat.dto.EmailResponseDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmailResponseDTO> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new EmailResponseDTO("SERVER_ERROR", 0.0));
    }
}