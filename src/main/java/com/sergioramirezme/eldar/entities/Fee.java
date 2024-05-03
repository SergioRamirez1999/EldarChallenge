package com.sergioramirezme.eldar.entities;

import com.sergioramirezme.eldar.enums.OperatorFeeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fee")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operator")
    private OperatorFeeEnum operator;

    @Column(name = "base_value")
    private Double base_value;

    @Column(name = "use_day")
    private Boolean day;

    @Column(name = "use_month")
    private Boolean month;

    @Column(name = "use_year")
    private Boolean year;


    //agregar metodo para calcular el fee en base a los datos de esta entidad. Utilizar alguna clase utilitaria.

}
