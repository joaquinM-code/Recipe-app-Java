package com.ecatom.recipeproject.services;

import com.ecatom.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long aLong);
}
