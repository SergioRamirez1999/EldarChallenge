package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sergioramirezme.eldar.validators.CardValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@CardValidation
public class CardDTO {

    @JsonProperty("brand")
    @NotBlank(message = "{payments.validation.msg.brand}")
    @Size(min = 3, max = 32, message = "{payments.validation.msg.brand}")
    private String brand;

    @JsonProperty("number")
    @NotBlank(message = "{payments.validation.msg.number}")
    @Size(min = 13, max = 22, message = "{payments.validation.msg.number}")
    private String number;

    @JsonProperty("card_holder")
    @NotBlank(message = "{payments.validation.msg.holder}")
    @Size(min = 5, max = 128, message = "{payments.validation.msg.holder}")
    private String cardHolder;

    @JsonProperty("due_date")
    @NotNull(message = "{payments.validation.msg.duedate.null}")
    private LocalDate dueDate;
}
