package com.lukaroncevic.spring5recipesapp.repositories;

import com.lukaroncevic.spring5recipesapp.domain.Category;
import com.lukaroncevic.spring5recipesapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
