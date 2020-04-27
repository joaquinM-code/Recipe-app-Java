package com.ecatom.recipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})//Prevents the stack overflow problem
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)//https://www.udemy.com/course/spring-framework-5-beginner-to-guru/learn/lecture/7496514#notes
    private UnitOfMeasure unitOfMeasure;
    private String description;

    @ManyToOne //Many ingredients can have one recipe
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(BigDecimal amount, UnitOfMeasure unitOfMeasure, String description) {
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.description = description;
    }
}
