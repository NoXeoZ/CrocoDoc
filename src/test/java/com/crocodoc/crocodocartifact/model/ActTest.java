package com.crocodoc.crocodocartifact.model;
/*
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActTest {

    @Test
    void getDescription() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.EXAM, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals("La description deabzejnaze^€&éeé&]€é nzkeazk ezae", act.getDescription());
        assertNotEquals("La description deabzejnaze¨€&éeé&]€é nzkeazk ezae", act.getDescription());
        assertNotEquals("La description deabzejnaze^€&éeé&]€é nzkeazk eza e", act.getDescription());
    }

    @Test
    void setDescription() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.EXAM, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        act.setDescription("jzae zeza@azezè ");
        assertEquals("jzae zeza@azezè ", act.getDescription());
        assertNotEquals("jzae zeza@azezé ", act.getDescription());
        assertNotEquals("jzae zeza@azezè", act.getDescription());

        assertThrows(NullPointerException.class, () -> { act.setDescription(null);});
        assertThrows(NullPointerException.class, () -> { act.setDescription((String) null);});
    }

    @Test
    void getCreatedAt() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.EXAM, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertNull(act.getCreatedAt());
        act.validate();
        LocalDateTime date = LocalDateTime.now();
        assertNotEquals(date, act.getCreatedAt());
        assertEquals(date.getYear(), act.getCreatedAt().getYear());
        assertEquals(date.getMonth(), act.getCreatedAt().getMonth());
        assertEquals(date.getDayOfMonth(), act.getCreatedAt().getDayOfMonth());
    }

    @Test
    void getType() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.EXAM, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals(ActType.EXAM, act.getType());
        assertEquals(2, act.getType().getId());
        assertNotEquals(ActType.OBSERVATION, act.getType());
        assertNotEquals(ActType.PRESCRIPTION, act.getType());
    }

    @Test
    void setType() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals(ActType.OBSERVATION, act.getType());

        act.setType(ActType.EXAM);
        assertEquals(ActType.EXAM, act.getType());
        assertEquals(2, act.getType().getId());
        assertNotEquals(ActType.OBSERVATION, act.getType());
        assertNotEquals(ActType.PRESCRIPTION, act.getType());
    }

    @Test
    void isDraft() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");

        assertTrue(act.isDraft());
        assertFalse(!act.isDraft());
    }

    @Test
    void validate() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");

        assertTrue(act.isDraft());
        assertFalse(!act.isDraft());
        act.validate();
        assertFalse(act.isDraft());
        assertTrue(!act.isDraft());
    }

    @Test
    void addAndGetImage() {
        // todo
    }

    @Test
    void removeImage() {
        // todo
    }

    @Test
    void getImagesTitles() {
        // todo
    }

    @Test
    void getAssignment() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("sazezaez zae za", StructureType.POLE);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Assignment assignment2 = new Assignment(test2, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals(assignment, act.getAssignment());
        assertNotEquals(assignment2, act.getAssignment());
    }

    @Test
    void setAssignment() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("sazezaez zae za", StructureType.POLE);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Assignment assignment2 = new Assignment(test2, hospitalization);
        Profile user = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals(assignment, act.getAssignment());
        assertNotEquals(assignment2, act.getAssignment());

        act.setAssignment(assignment2);
        assertEquals(assignment2, act.getAssignment());
        assertNotEquals(assignment, act.getAssignment());
    }

    @Test
    void getUser() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();
        Profile user2 = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals(user, act.getUser());
        assertNotEquals(user2, act.getUser());
    }

    @Test
    void setUser() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Assignment assignment = new Assignment(test, hospitalization);
        Profile user = new Profile();
        Profile user2 = new Profile();

        Act act = new Act(user, ActType.OBSERVATION, assignment, "La description deabzejnaze^€&éeé&]€é nzkeazk ezae");
        assertEquals(user, act.getUser());
        assertNotEquals(user2, act.getUser());

        act.setUser(user2);
        assertEquals(user2, act.getUser());
        assertNotEquals(user, act.getUser());
    }
}
*/
