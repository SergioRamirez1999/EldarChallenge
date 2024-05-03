package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFeeInquiryReqDTO {

    @Size(min = 3, max = 32)
    @JsonProperty("brand")
    private String brand;

    @Positive
    @JsonProperty("amount")
    private double amount;
}
