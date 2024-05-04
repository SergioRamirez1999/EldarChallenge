package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sergioramirezme.eldar.validators.DueDateValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@DueDateValidation
public class CardDTO {

    @JsonProperty("brand")
    @Size(min = 3, max = 32, message = "{payments.validation.msg.brand}")
    private String brand;

    @JsonProperty("number")
    @Size(min = 13, max = 22, message = "{payments.validation.msg.number}")
    private String number;

    @JsonProperty("card_holder")
    @Size(min = 5, max = 128, message = "{payments.validation.msg.holder}")
    private String cardHolder;

    @JsonProperty("due_date")
    private LocalDate dueDate;
}
