package com.sergioramirezme.eldar.resources;

import com.sergioramirezme.eldar.business.PaymentBO;
import com.sergioramirezme.eldar.dtos.PaymentDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryReqDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryResDTO;
import com.sergioramirezme.eldar.dtos.PurchaseResDTO;
import com.sergioramirezme.eldar.exceptions.BusinessException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
@Validated
public class PaymentResource {

    private PaymentBO paymentBO;

    @Autowired
    public PaymentResource(PaymentBO paymentBO) {
        this.paymentBO = paymentBO;
    }

    @GetMapping("/consult-fee")
    public ResponseEntity<PaymentFeeInquiryResDTO> inquiryFee(@Valid @RequestBody PaymentFeeInquiryReqDTO paymentFeeInquiryReqDTO) throws BusinessException {
        PaymentFeeInquiryResDTO paymentFeeInquiryResDTO = paymentBO.inquiryFee(paymentFeeInquiryReqDTO);
        return ResponseEntity.ok(paymentFeeInquiryResDTO);
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResDTO> inquiryFee(@Valid @RequestBody PaymentDTO paymentDTO) throws BusinessException {
        paymentBO.processPayment(paymentDTO);
        PurchaseResDTO purchaseResDTO = PurchaseResDTO.builder().message("OK").build();
        return ResponseEntity.ok(purchaseResDTO);
    }
}
