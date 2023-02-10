package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
