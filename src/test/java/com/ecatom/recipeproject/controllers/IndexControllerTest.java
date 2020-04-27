package com.ecatom.recipeproject.controllers;


import com.ecatom.recipeproject.domain.Recipe;
import com.ecatom.recipeproject.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);//Create an instance of the controller to test
    }


    @Test
    public void testMockMVC() throws Exception{
        //Creating mock MVC to mock and test a servlet
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getIndexPage() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);//Build a new ArgumentCaptor for specified class
        //https://www.javadoc.io/doc/org.mockito/mockito-core/2.6.9/org/mockito/ArgumentCaptor.html

        //when
        //Call the getIndexPage
        String viewName = indexController.getIndexPage(model);

        //then
        //Verify that returns the String "index"
        assertEquals("index" , viewName);
        //Verify that model and recipeService are called one time  ////--eq() verifies that the value passed is the one specified
        verify(model , times(1)).addAttribute(eq("recipes") , argumentCaptor.capture());//anySet() is a mockito method to simulate a set
        verify(recipeService , times(1)).getRecipes();

        //Verify that the size of the Set is exactly 2
        Set<Recipe> setIndexController = argumentCaptor.getValue();
        System.out.println(argumentCaptor.getValue());//
        assertEquals(2,setIndexController.size());
    }
}