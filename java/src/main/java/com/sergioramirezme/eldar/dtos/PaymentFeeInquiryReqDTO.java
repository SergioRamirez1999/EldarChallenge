package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PaymentFeeInquiryReqDTO {

    @NotBlank(message = "{payments.validation.msg.brand}")
    @Size(min = 3, max = 32, message = "{payments.validation.msg.brand}")
    @JsonProperty("brand")
    private String brand;

    @Positive(message = "{payments.validation.msg.amount}")
    @Max(value = 1000, message = "{payments.validation.msg.amount}")
    @JsonProperty("amount")
    private double amount;
}
