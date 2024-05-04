package com.sergioramirezme.eldar.entities;

import com.sergioramirezme.eldar.utils.NashornUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Column(name = "math_expression")
    private String expression;

    @ToString.Exclude
    @OneToMany(mappedBy = "fee", fetch = FetchType.EAGER)
    private List<ArgumentExpression> arguments;

}
