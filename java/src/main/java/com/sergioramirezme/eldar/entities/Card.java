package com.sergioramirezme.eldar.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(
    name = "cards",
    uniqueConstraints = {
            @UniqueConstraint(name = "uk_brand_number_cardholder_duedate", columnNames = { "id_brand", "number", "card_holder", "due_date" })
    })

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_cards")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_brand")
    private BrandCard brand;

    @Column(name = "number")
    private String number;

    @Column(name = "card_holder")
    private String cardHolder;

    @Column(name = "due_date")
    private LocalDate dueDate;


    public boolean isValidPayment(double amount) {
        return amount < 1000;
    }

    public boolean isValid() {
        return LocalDate.now().isBefore(dueDate);
    }


    public boolean isSameCard(Card card) {
        return this.equals(card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(brand, card.brand) && Objects.equals(number, card.number) && Objects.equals(cardHolder, card.cardHolder) && Objects.equals(dueDate, card.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number, cardHolder, dueDate);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", brand=" + brand +
                ", number='" + number + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", dueDate=" + dueDate + '\'' +
                ", feeExpression=" + brand.getFee().getExpression() + '\'' +
                '}';
    }
}
