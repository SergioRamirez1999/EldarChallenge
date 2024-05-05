package com.sergioramirezme.eldar.validators;

import com.sergioramirezme.eldar.dtos.CardDTO;
import com.sergioramirezme.eldar.entities.Card;
import com.sergioramirezme.eldar.repositories.ICardRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CardValidator implements ConstraintValidator<CardValidation, CardDTO> {


    private ICardRepository cardRepository;

    @Autowired
    public CardValidator(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void initialize(CardValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CardDTO dto, ConstraintValidatorContext context) {

        Card card = cardRepository.findByNumberAndDueDateAndBrandName(dto.getNumber(), dto.getDueDate(), dto.getBrand());

        if (card == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{payments.validation.msg.card.notfound}")
                    .addConstraintViolation();
            return false;
        }


        return LocalDate.now().isBefore(card.getDueDate());

    }
}
