package com.sergioramirezme.eldar.repositories;

import com.sergioramirezme.eldar.entities.BrandCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandCardRepository extends JpaRepository<BrandCard, Integer> {
    BrandCard findByName(String name);
}
