package com.lukaroncevic.spring5recipesapp.repositories;

import com.lukaroncevic.spring5recipesapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
