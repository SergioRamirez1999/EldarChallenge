package com.sergioramirezme.eldar.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(
    name = "cards",
    uniqueConstraints = {
            @UniqueConstraint(name = "uk_brand_number_cardholder_duedate", columnNames = { "id_brand", "number", "card_holder", "due_date" })
    })

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    //Metodo para obtener toda la información de una tarjeta
    public String getInfo() {
        //Generar un "toString" que contenga todos los campos y la lógica para calcular su tasa
        String info = "";

        return info;
    }

    //Metodo para saber si una operacion es valida basada sólo en su amount (max 1000)
    public boolean isValidPayment(double amount) {
        return amount < 1000;
    }

    //Metodo para saber si la tarjeta es válida para operar sólo basándose en su fecha de expiración
    public boolean isValid() {
        return LocalDate.now().isBefore(dueDate);
    }


    //Metodo para saber si las tarjetas son iguales
    public boolean areCardsSame(Card card) {
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
}
