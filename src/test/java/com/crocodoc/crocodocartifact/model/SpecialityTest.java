package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityTest {

    @Test
    void getName() {
        Speciality test = new Speciality("Opération du Coeur", "On t'ouvre en deux et rpend ton coeur");
        assertEquals("Opération du Coeur", test.getName());
        assertNotEquals("Opération du Coeur ", test.getName());
        assertNotEquals("Opération du coeur", test.getName());
        assertNotEquals("Operation du Coeur", test.getName());
    }

    @Test
    void setName() {
        Speciality test = new Speciality("Nom bizarrre", "On t'ouvre en deux et rpend ton coeur");

        test.setName("Opération du Coeur");
        assertEquals("Opération du Coeur", test.getName());
        assertNotEquals("Opération du Coeur ", test.getName());
        assertNotEquals("Opération du coeur", test.getName());
        assertNotEquals("Operation du Coeur", test.getName());

        assertThrows(NullPointerException.class, () -> { test.setName(null); });
        assertThrows(NullPointerException.class, () -> { test.setName((String) null); });
    }

    @Test
    void getDescription() {
        Speciality test = new Speciality("Opération du Coeur", "On t'ouvre en deux et rpend ton coeur");
        assertEquals("On t'ouvre en deux et rpend ton coeur", test.getDescription());
        assertNotEquals("On t'ouvre en  deux et rpend ton coeur", test.getDescription());
        assertNotEquals("on t'ouvre en deux et rpend ton coeur", test.getDescription());
        assertNotEquals("On t`ouvre en deux et rpend ton coeur", test.getDescription());
    }

    @Test
    void setDescription() {
        Speciality test = new Speciality("Opération du Coeur", "On t'ouvre edazdzadzar");

        test.setDescription("On t'ouvre en deux et rpend ton coeur");
        assertEquals("On t'ouvre en deux et rpend ton coeur", test.getDescription());
        assertNotEquals("On t'ouvre en  deux et rpend ton coeur", test.getDescription());
        assertNotEquals("on t'ouvre en deux et rpend ton coeur", test.getDescription());
        assertNotEquals("On t`ouvre en deux et rpend ton coeur", test.getDescription());

        assertThrows(NullPointerException.class, () -> { test.setDescription(null); });
        assertThrows(NullPointerException.class, () -> { test.setDescription((String) null); });
    }
}
