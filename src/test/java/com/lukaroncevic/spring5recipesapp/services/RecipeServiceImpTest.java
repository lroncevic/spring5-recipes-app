package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.converters.RecipeCommandsToRecipe;
import com.lukaroncevic.spring5recipesapp.converters.RecipeToRecipeCommand;
import com.lukaroncevic.spring5recipesapp.domain.Recipe;
import com.lukaroncevic.spring5recipesapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImpTest {

    RecipeServiceImp recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeCommandsToRecipe recipeCommandsToRecipe;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImp(recipeRepository, recipeCommandsToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void  getRecipeIdTest(){

        Recipe recipe= new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull(recipeReturned, "Null recipe returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }


    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet<>();
        recipesData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }
}