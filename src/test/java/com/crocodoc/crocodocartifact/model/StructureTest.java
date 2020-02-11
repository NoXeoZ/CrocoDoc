package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

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

    @Test
    void getSpecialities() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertEquals(0, test.getSpecialities().size());
    }

    @Test
    void addSpeciality() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        Speciality spe1 = new Speciality("Spécialité 1", "Petite description tu coco");
        Speciality spe2 = new Speciality("Spécialité 2", "Petite description tu coco");
        Speciality spe3 = new Speciality("Spécialité 3", "Petite description tu coco");

        test.addSpeciality(spe1);
        test.addSpeciality(spe2);
        test.addSpeciality(spe3);

        assertEquals(3, test.getSpecialities().size());
        assertTrue(test.getSpecialities().contains(spe1));
        assertTrue(test.getSpecialities().contains(spe2));
        assertTrue(test.getSpecialities().contains(spe3));

        assertThrows(NullPointerException.class, ()->{ test.addSpeciality(null);});
        assertThrows(NullPointerException.class, ()->{ test.addSpeciality((Speciality) null);});
    }

    @Test
    void removeSpeciality() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        Speciality spe1 = new Speciality("Spécialité 1", "Petite description tu coco");
        Speciality spe2 = new Speciality("Spécialité 2", "Petite description tu coco");
        Speciality spe3 = new Speciality("Spécialité 3", "Petite description tu coco");

        test.addSpeciality(spe1);
        test.addSpeciality(spe2);
        test.addSpeciality(spe3);

        test.removeSpeciality(spe2);
        assertEquals(2, test.getSpecialities().size());
        assertFalse(test.getSpecialities().contains(spe2));
        assertTrue(test.getSpecialities().contains(spe1));
        assertTrue(test.getSpecialities().contains(spe3));
    }

    @Test
    void getChief() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        assertNull(test.getChief());
    }

    @Test
    void setChief() {
        Structure test = new Structure("Hôpital @Test", StructureType.HOSPITAL);
        User user1 = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        User user2 = new User("zadzad", "zedazazd", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);

        test.setChief(user1);
        assertEquals(user1, test.getChief());
        assertNotEquals(user2, test.getChief());

        test.setChief(user2);
        assertEquals(user2, test.getChief());
        assertNotEquals(user1, test.getChief());

        test.setChief(null);
        assertNull(test.getChief());
    }
}
