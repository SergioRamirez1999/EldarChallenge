package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    @JsonProperty("card")
    @NotNull(message = "{payments.validation.msg.card.notfound}")
    @Valid
    private CardDTO card;

    @Positive(message = "{payments.validation.msg.amount}")
    @Max(value = 1000, message = "{payments.validation.msg.amount}")
    @JsonProperty("amount")
    private double amount;
}
