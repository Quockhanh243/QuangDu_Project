package com.oriz.backend_system.controllers;

import com.oriz.backend_system.model.PaymentInformation;
import com.oriz.backend_system.services.PaymentInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentInformationController {

    private final PaymentInformationService paymentInformationService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentInformation> getPaymentInformationById(@PathVariable Long id) {
        PaymentInformation paymentInformation = paymentInformationService.getPaymentInformationById(id);
        if (paymentInformation != null) {
            return ResponseEntity.ok(paymentInformation);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PaymentInformation> addPaymentInformation(@RequestBody PaymentInformation paymentInformation) {
        PaymentInformation addedPaymentInformation = paymentInformationService.addPaymentInformation(paymentInformation);
        return ResponseEntity.ok(addedPaymentInformation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentInformation> updatePaymentInformation(@PathVariable Long id, @RequestBody PaymentInformation paymentInformation) {
        PaymentInformation updatedPaymentInformation = paymentInformationService.updatePaymentInformation(id, paymentInformation);
        if (updatedPaymentInformation != null) {
            return ResponseEntity.ok(updatedPaymentInformation);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentInformation(@PathVariable Long id) {
        paymentInformationService.deletePaymentInformation(id);
        return ResponseEntity.noContent().build();
    }
}
