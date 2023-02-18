package com.lukaroncevic.spring5recipesapp.converters;

import com.lukaroncevic.spring5recipesapp.commands.IngredientCommand;
import com.lukaroncevic.spring5recipesapp.commands.UnitOfMeasureCommand;
import com.lukaroncevic.spring5recipesapp.domain.Ingredient;
import com.lukaroncevic.spring5recipesapp.domain.Recipe;
import com.lukaroncevic.spring5recipesapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "description";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }
    @Test
    void convert() {
        //given
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }

    @Test
    void convertWithNullUOM() {
        //given
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setUom(null);

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }
}