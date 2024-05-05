package com.sergioramirezme.eldar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_brand_card")
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name = "id_fee", unique = false)
    private Fee fee;
}
