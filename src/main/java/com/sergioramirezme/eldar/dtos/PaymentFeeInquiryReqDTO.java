package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PaymentFeeInquiryReqDTO {

    @Size(min = 3, max = 32, message = "{payments.validation.msg.brand}")
    @JsonProperty("brand")
    private String brand;

    @Positive
    @Max(value = 1000, message = "{payments.validation.msg.amount}")
    @JsonProperty("amount")
    private double amount;
}
