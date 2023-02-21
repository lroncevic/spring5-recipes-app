package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.commands.UnitOfMeasureCommand;
import com.lukaroncevic.spring5recipesapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.lukaroncevic.spring5recipesapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UnitOfMeasureImp implements UnitOfMeasureService{

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureImp(UnitOfMeasureRepository unitOfMeasureRepository,
                            UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                        .spliterator(), false)
                        .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                        .collect(Collectors.toSet());
    }
}
