package com.sergioramirezme.eldar.resources;

import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryReqDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryResDTO;
import com.sergioramirezme.eldar.exceptions.BusinessException;
import com.sergioramirezme.eldar.exceptions.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@Validated
public class PaymentResource {

    @GetMapping("/consult-fee")
    private ResponseEntity<PaymentFeeInquiryResDTO> inquiryFee(@RequestBody PaymentFeeInquiryReqDTO paymentFeeInquiryReqDTO) throws ValidationException, BusinessException {
        PaymentFeeInquiryResDTO paymentFeeInquiryResDTO = new PaymentFeeInquiryResDTO();
        return ResponseEntity.ok(paymentFeeInquiryResDTO);
    }
}
