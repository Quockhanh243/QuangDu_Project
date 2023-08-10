package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.PaymentInformation;
import com.oriz.backend_system.repositories.PaymentInformationRepository;
import com.oriz.backend_system.services.PaymentInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentInformationServiceImpl implements PaymentInformationService {

    private final PaymentInformationRepository paymentInformationRepository;

    @Override
    public PaymentInformation getPaymentInformationById(Long id) {
        return paymentInformationRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentInformation addPaymentInformation(PaymentInformation paymentInformation) {
        return paymentInformationRepository.save(paymentInformation);
    }

    @Override
    public PaymentInformation updatePaymentInformation(Long id, PaymentInformation paymentInformation) {
        Optional<PaymentInformation> existingPaymentInformation = paymentInformationRepository.findById(id);
        if (existingPaymentInformation.isPresent()) {
            PaymentInformation updatedPaymentInformation = existingPaymentInformation.get();
            updatedPaymentInformation.setCard_number(paymentInformation.getCard_number());
            updatedPaymentInformation.setCard_holder(paymentInformation.getCard_holder());
            updatedPaymentInformation.setCvv(paymentInformation.getCvv());
            updatedPaymentInformation.setCustomer(paymentInformation.getCustomer());
            // Set other properties as needed
            return paymentInformationRepository.save(updatedPaymentInformation);
        }
        return null; // PaymentInformation ID is missing or not found
    }

    @Override
    public void deletePaymentInformation(Long id) {
        paymentInformationRepository.deleteById(id);
    }

    // Implement methods for PaymentInformation-related operations
}
