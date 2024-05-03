package com.sergioramirezme.eldar.dtos;

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
public class CardDTO {
    @Size(min = 3, max = 32)
    private String brand;

    @Size(min = 13, max = 18)
    private String number;

    @NotBlank
    @Size(max = 128)
    private String cardHolder;

    @DueDateValidation
    private LocalDate dueDate;
}
