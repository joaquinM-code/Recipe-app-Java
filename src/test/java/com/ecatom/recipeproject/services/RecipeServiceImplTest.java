package com.ecatom.recipeproject.services;

import com.ecatom.recipeproject.domain.Recipe;
import com.ecatom.recipeproject.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe1 = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe1);

        //THis tells mockito that when recipeRepository is call, return recipesData
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        //Verifies that the findAll() method is called one time
        verify(recipeRepository, times(1)).findAll();

    }
}