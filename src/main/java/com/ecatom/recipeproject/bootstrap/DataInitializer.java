package com.ecatom.recipeproject.bootstrap;

import com.ecatom.recipeproject.domain.*;
import com.ecatom.recipeproject.repositories.CategoryRepository;
import com.ecatom.recipeproject.repositories.RecipeRepository;
import com.ecatom.recipeproject.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component//By declaring it as a component, becomes a Spring bean and gets registered into the context
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    //Spring IoC Container will implement the methods
    public DataInitializer(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        //getUOMs
        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        if(!teaspoonUomOptional.isPresent()){//isPresent() returns true if Optional has a value
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");
        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByUom("Cup");
        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cloveUomOptional = unitOfMeasureRepository.findByUom("Clove");
        if(!cloveUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByUom("Pinch");
        if(!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> gramUomOptional = unitOfMeasureRepository.findByUom("Gram");
        if(!gramUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> unitUomOptional = unitOfMeasureRepository.findByUom("Unit");
        if(!unitUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        //Get uom optionals
        UnitOfMeasure teaspoonUom = tablespoonUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure cloveUom = cloveUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure gramUom = gramUomOptional.get();
        UnitOfMeasure unitUom = unitUomOptional.get();

        //get categories
        Optional<Category> spanishCategory = categoryRepository.findByName("Spanish");
        if(!spanishCategory.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> italianCategory = categoryRepository.findByName("Italian");
        if(!italianCategory.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> americanCategory = categoryRepository.findByName("American");
        if(!americanCategory.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> chineseCategory = categoryRepository.findByName("Chinese");
        if(!chineseCategory.isPresent()){
            throw new RuntimeException("Expected category not found");
        }

        //get categories optionals

        Category spanishCat = spanishCategory.get();
        Category americanCat = americanCategory.get();
        Category chineseCat = chineseCategory.get();
        Category italianCat = italianCategory.get();

        //Spring Vegetable Tortellini Soup with Pesto
        Recipe tortelliniSoup = new Recipe();
        tortelliniSoup.setDifficulty(Difficulty.EASY);
        tortelliniSoup.setCookTime(25);
        tortelliniSoup.setPrepTime(10);
        tortelliniSoup.getCategories().add(italianCat);
        tortelliniSoup.getCategories().add(spanishCat);
        tortelliniSoup.setDescription("Spring Vegetable Tortellini Soup with Pesto");
        tortelliniSoup.setDirections(
                "1 Sauté the onions and garlic: Heat the olive oil in a medium pot over medium heat. Add the onion and garlic and sauté until tender, being sure not to brown them, about 5 minutes."+
                "\n"
                +"2 Build the soup: Add the carrots and broth and turn the heat to high. When the broth boils, add the tortellini, snap peas, English peas, and asparagus. Continue to boil until the tortellini is just barely al dente. The time will vary depending on the brand, so read the package instructions."+
                "\n"
                +"3 Season the soup: Add the lemon juice, several cracks of black pepper, and 1 to 2 teaspoons salt, as needed (some broth is saltier than others, so adjust according to taste)." +
                "\n"
                +"Ladle the soup into bowls and top with a spoonful of pesto. Serve immediately.");
        Notes tortelliniNotes = new Notes();
        tortelliniNotes.setRecipeNotes("This recipe has two back-pocket ingredients that make quick work of dinner: store-bought tortellini and pesto. You’ll find tortellini in the refrigerated or freezer section of the supermarket.\n" +
                "\n" +
                "You can either pick up a tub of herb pesto at the market or make your own if time permits. Either way, this soup comes together pretty quickly once you’ve got your vegetables chopped.");
        tortelliniSoup.setNotes(tortelliniNotes);

        //Ingredients
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , tablespoonUom , "olive oil"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , unitUom , "medium onion"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(2) , cloveUom , "garlic"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , cupUom , "sliced carrots"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(6) , cupUom , "low sodium vegetable broth"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(240) , gramUom , "tortellini"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , cupUom , "snap peas, cut into thirds"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(0.5) , cupUom , "fresh or frozen English peas"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , cupUom , "3/4-inch pieces asparagus, woody ends removed"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , tablespoonUom , "fresh lemon juice"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , teaspoonUom , "kosher salt"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(1) , teaspoonUom , "Freshly cracked black pepper"));
        tortelliniSoup.addIngredient(new Ingredient(new BigDecimal(0.75) , cupUom , "herb pesto, either store-bought or homemade"));

        //Metadata
        tortelliniSoup.setUrl("https://www.simplyrecipes.com/recipes/spring_vegetable_tortellini_soup_with_pesto/");
        tortelliniSoup.setSource("KATIE MORFORD");

        //Adding recipe
        recipes.add(tortelliniSoup);
        log.debug("Loading recipes complete.......");
        return recipes;

    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());

    }
}
