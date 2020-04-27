package com.ecatom.recipeproject.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//https://thoughts-on-java.org/jpa-generate-primary-keys/
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Lob //Large object
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
//https://www.udemy.com/course/spring-framework-5-beginner-to-guru/learn/lecture/7496686#notes
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)//https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/
    private Notes notes;

    //One recipe can have many ingredients
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")//mappedBy establishes the foreign key
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany//https://www.udemy.com/course/spring-framework-5-beginner-to-guru/learn/lecture/7496692#notes
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
