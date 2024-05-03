package com.sergioramirezme.eldar.repositories;

import com.sergioramirezme.eldar.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Card, Integer> {

    Card findByBrandName(String name);
}
