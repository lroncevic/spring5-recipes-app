package com.lukaroncevic.spring5recipesapp.controllers;

import com.lukaroncevic.spring5recipesapp.domain.Category;
import com.lukaroncevic.spring5recipesapp.domain.UnitOfMeasure;
import com.lukaroncevic.spring5recipesapp.repositories.CategoryRepository;
import com.lukaroncevic.spring5recipesapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureRepositoryOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("UOM ID is " + unitOfMeasureRepositoryOptional.get().getId());

        return "index";
    }
}
