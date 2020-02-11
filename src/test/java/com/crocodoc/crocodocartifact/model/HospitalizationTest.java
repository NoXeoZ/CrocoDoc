package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HospitalizationTest {

    @Test
    void getandSetStartDate() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        Hospitalization hospitalization = new Hospitalization(test, dmp);
        assertNotNull(hospitalization.getStartDate());

        LocalDateTime date = LocalDateTime.now();
        assertNotEquals(date, hospitalization.getStartDate());
        hospitalization.setStartDate(date);
        assertEquals(date, hospitalization.getStartDate());

        assertThrows(NullPointerException.class, ()->{ hospitalization.setStartDate(null); });
        assertThrows(NullPointerException.class, ()->{ hospitalization.setStartDate((LocalDateTime) null); });
    }

    @Test
    void getAndSetEndDate() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        assertNull(hospitalization.getEndDate());

        LocalDateTime date = LocalDateTime.now();
        hospitalization.setEndDate(date);
        assertEquals(date, hospitalization.getEndDate());

        assertThrows(NullPointerException.class, ()->{ hospitalization.setEndDate(null); });
        assertThrows(NullPointerException.class, ()->{ hospitalization.setEndDate((LocalDateTime) null); });
    }

    @Test
    void finish() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        Hospitalization hospitalization = new Hospitalization(test, dmp);
        hospitalization.finish();

        LocalDateTime date = LocalDateTime.now();
        assertEquals(date.getYear(), hospitalization.getEndDate().getYear());
        assertEquals(date.getMonth(), hospitalization.getEndDate().getMonth());
        assertEquals(date.getDayOfMonth(), hospitalization.getEndDate().getDayOfMonth());
        assertEquals(date.getHour(), hospitalization.getEndDate().getHour());
    }

    @Test
    void getHospital() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        Hospitalization hospitalization = new Hospitalization(test, dmp);

        assertEquals(test.getName(), hospitalization.getHospital().getName());
        assertEquals(test.getType(), hospitalization.getHospital().getType());
    }

    @Test
    void getDMP() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        Hospitalization hospitalization = new Hospitalization(test, dmp);
        assertEquals(dmp.getFirstname(), hospitalization.getDMP().getFirstname());
        assertEquals(dmp.getLastname(), hospitalization.getDMP().getLastname());
        assertEquals(dmp.getBirth(), hospitalization.getDMP().getBirth());
        assertEquals(dmp.getFirstname(), hospitalization.getDMP().getFirstname());
        assertEquals(dmp.getLastname(), hospitalization.getDMP().getLastname());
        assertEquals(dmp.getBirth(), hospitalization.getDMP().getBirth());

        dmp.setFirstname("Boo");
        assertEquals(dmp.getFirstname(), hospitalization.getDMP().getFirstname());
    }

    @Test
    void getandAddAssignments() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("Secteur zbeul", StructureType.SERVICE);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment1 = new Assignment(test, hospitalization);
        Assignment assignment2 = new Assignment(test, hospitalization);
        Assignment assignment3 = new Assignment(test2, hospitalization);

        assertEquals(0, hospitalization.getAssignments().size());
        assertThrows(NullPointerException.class, () -> {hospitalization.addAssignment(null);});
        assertThrows(NullPointerException.class, () -> {hospitalization.addAssignment((Assignment) null);});

        hospitalization.addAssignment(assignment1);
        hospitalization.addAssignment(assignment2);
        hospitalization.addAssignment(assignment3);
        assertEquals(3, hospitalization.getAssignments().size());
        assertEquals(assignment2.getService().getName(), hospitalization.getAssignments().get(1).getService().getName());
        assertEquals(assignment3.getService().getName(), hospitalization.getAssignments().get(2).getService().getName());
    }
}
