package com.ecatom.recipeproject.domain;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
