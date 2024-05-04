package com.sergioramirezme.eldar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="argument_expression")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArgumentExpression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_argument_expression")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "default_value")
    private Double defaultValue;

    @ManyToOne
    @JoinColumn(name = "id_fee")
    @ToString.Exclude
    private Fee fee;
}
