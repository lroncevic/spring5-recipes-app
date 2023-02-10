package com.lukaroncevic.spring5recipesapp.controllers;

import com.lukaroncevic.spring5recipesapp.domain.Category;
import com.lukaroncevic.spring5recipesapp.domain.UnitOfMeasure;
import com.lukaroncevic.spring5recipesapp.repositories.CategoryRepository;
import com.lukaroncevic.spring5recipesapp.repositories.UnitOfMeasureRepository;
import com.lukaroncevic.spring5recipesapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
