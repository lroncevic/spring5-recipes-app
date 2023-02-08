package com.lukaroncevic.spring5recipesapp.repositories;

import com.lukaroncevic.spring5recipesapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
