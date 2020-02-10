package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StructureTest {

    @Test
    void getName() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertEquals("Hôpital @Test", test.getName());
        assertNotEquals("Hôpital }Test", test.getName());
        assertNotEquals("Höpital }Test", test.getName());
        assertNotEquals("Hôpital @test", test.getName());
    }

    @Test
    void setName() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertEquals("Hôpital @Test", test.getName());

        test.setName("Nouveau_Nomzer");
        assertEquals("Nouveau_Nomzer", test.getName());
        assertNotEquals("Nouveau-Nomzer", test.getName());
        assertNotEquals("nouveau_Nomzer", test.getName());
        assertNotEquals("Nouveau_Nomzer ", test.getName());

        assertThrows(NullPointerException.class, () -> { test.setName(null);});
        assertThrows(NullPointerException.class, () -> { test.setName((String) null);});
    }

    @Test
    void getType() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertEquals(StructureType.HOSPITAL, test.getType());
        assertEquals(1, test.getType().getId());
        assertNotEquals(3, test.getType().getId());
        assertNotEquals(StructureType.HOSPITAL_UNIT, test.getType());
    }

    @Test
    void setType() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        test.setType(StructureType.FUNCTIONAL_UNIT);
        assertEquals(StructureType.FUNCTIONAL_UNIT, test.getType());
        assertEquals(4, test.getType().getId());
        assertNotEquals(3, test.getType().getId());
        assertNotEquals(StructureType.HOSPITAL_UNIT, test.getType());

        assertThrows(NullPointerException.class, () -> { test.setType(null);});
        assertThrows(NullPointerException.class, () -> { test.setType((StructureType) null);});
    }

    @Test
    void getDescription() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertNull(test.getDescription());
    }

    @Test
    void setDescription() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        test.setDescription("zauehza ezahezau e eazezej.akeh zezezoe");
        assertEquals("zauehza ezahezau e eazezej.akeh zezezoe", test.getDescription());
        assertNotEquals("zauehza ezahezau e eazezej:akeh zezezoe", test.getDescription());
        assertNotEquals("zauehza ezahezau e eazezej.akeh zezezoe ", test.getDescription());
        assertNotEquals("zauehza ezahezau e eazezej.aeeh zezezoe", test.getDescription());

        test.setDescription(null);
        assertNull(test.getDescription());
    }

    @Test
    void getParent() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertNull(test.getParent());
    }

    @Test
    void setParent() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        Structure test2 = new Structure("Service de Test", StructureType.SERVICE);

        assertThrows(NullPointerException.class, () -> { test.setParent(null);});
        assertThrows(NullPointerException.class, () -> { test.setParent((Structure) null);});
        assertThrows(IllegalArgumentException.class, () -> { test.setParent(test);});

        test2.setParent(test);
        assertEquals(test, test2.getParent());
        assertNotEquals(test2, test2.getParent());
    }
}
