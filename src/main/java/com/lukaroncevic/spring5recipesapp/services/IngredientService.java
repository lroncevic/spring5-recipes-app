package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeAndIngredientId(Long recipeId, Long ingredientId);
}
