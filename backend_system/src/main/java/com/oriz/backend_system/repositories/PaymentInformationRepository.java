package com.oriz.backend_system.repositories;

import com.oriz.backend_system.model.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Long> {
}
