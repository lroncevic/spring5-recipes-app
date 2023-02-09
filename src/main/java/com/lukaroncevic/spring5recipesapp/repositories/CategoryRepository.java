package com.lukaroncevic.spring5recipesapp.repositories;

import com.lukaroncevic.spring5recipesapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
