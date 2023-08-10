package com.oriz.backend_system.services;

import com.oriz.backend_system.model.PaymentInformation;

public interface PaymentInformationService {
    PaymentInformation getPaymentInformationById(Long id);

    PaymentInformation addPaymentInformation(PaymentInformation paymentInformation);

    PaymentInformation updatePaymentInformation(Long id, PaymentInformation paymentInformation);

    void deletePaymentInformation(Long id);

    // Add methods for PaymentInformation-related operations
}
