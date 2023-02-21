package com.lukaroncevic.spring5recipesapp.services;

import com.lukaroncevic.spring5recipesapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
