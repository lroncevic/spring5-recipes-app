package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.commands.RecipeCommand;
import com.lukaroncevic.spring5recipesapp.converters.RecipeCommandsToRecipe;
import com.lukaroncevic.spring5recipesapp.converters.RecipeToRecipeCommand;
import com.lukaroncevic.spring5recipesapp.domain.Recipe;
import com.lukaroncevic.spring5recipesapp.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Autowired
    RecipeCommandsToRecipe recipeCommandsToRecipe;

    @Transactional
    @Test
    public void testSavedOfDescription() throws Exception {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredient().size(), savedRecipeCommand.getIngredients().size());
    }

}