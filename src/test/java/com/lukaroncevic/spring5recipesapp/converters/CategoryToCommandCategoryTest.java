package com.lukaroncevic.spring5recipesapp.converters;

import com.lukaroncevic.spring5recipesapp.commands.CategoryCommand;
import com.lukaroncevic.spring5recipesapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCommandCategoryTest {

    public static final Long ID_VALUE = 1L;

    public static final String DESCRIPTION = "description";

    CategoryToCommandCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryToCommandCategory();
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    void convert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}