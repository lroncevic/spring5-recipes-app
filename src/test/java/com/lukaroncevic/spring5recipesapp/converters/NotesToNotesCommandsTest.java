package com.lukaroncevic.spring5recipesapp.converters;

import com.lukaroncevic.spring5recipesapp.commands.NotesCommand;
import com.lukaroncevic.spring5recipesapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandsTest {

    private static final Long ID_VALUE = 1L;
    private static final String RECIPE_NOTES = "notes";

    NotesToNotesCommands converter;

    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommands();
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void convert() {
        //given
        final Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand notesCommand = converter.convert(notes);

        //then
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}