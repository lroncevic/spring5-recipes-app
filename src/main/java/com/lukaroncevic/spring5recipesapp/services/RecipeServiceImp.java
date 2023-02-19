package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.commands.RecipeCommand;
import com.lukaroncevic.spring5recipesapp.converters.RecipeCommandsToRecipe;
import com.lukaroncevic.spring5recipesapp.converters.RecipeToRecipeCommand;
import com.lukaroncevic.spring5recipesapp.domain.Recipe;
import com.lukaroncevic.spring5recipesapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final RecipeCommandsToRecipe recipeCommandsToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImp(RecipeRepository recipeRepository, RecipeCommandsToRecipe recipeCommandsToRecipe,
                            RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandsToRecipe = recipeCommandsToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (recipeOptional.isEmpty()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command){
        Recipe detachedRecipe = recipeCommandsToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
