package com.scs.emailthreat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scs.emailthreat.model.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
