package com.sergioramirezme.eldar.repositories;

import com.sergioramirezme.eldar.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer> {
    Card findByNumberAndDueDateAndBrandName(String number, LocalDate dueDate, String name);
}
