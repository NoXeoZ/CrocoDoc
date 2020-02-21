package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {

    @Test
    void getandSetStartDate() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);
        LocalDateTime date = LocalDateTime.now();
        assertNotEquals(date, assignment.getStartDate());
        assertEquals(date.getYear(), assignment.getStartDate().getYear());
        assertEquals(date.getMonth(), assignment.getStartDate().getMonth());
        assertEquals(date.getDayOfMonth(), assignment.getStartDate().getDayOfMonth());

        assignment.setStartDate(date);
        assertEquals(date, assignment.getStartDate());

        assertThrows(NullPointerException.class, ()->{ assignment.setStartDate(null); });
        assertThrows(NullPointerException.class, ()->{ assignment.setStartDate((LocalDateTime) null); });
    }

    @Test
    void getAndSetEndDate() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);
        LocalDateTime date = LocalDateTime.now();
        assertNull(assignment.getEndDate());
        assignment.setEndDate(date);
        assertEquals(date, assignment.getEndDate());

        assertThrows(NullPointerException.class, ()->{ assignment.setEndDate(null); });
        assertThrows(NullPointerException.class, ()->{ assignment.setEndDate((LocalDateTime) null); });
    }

    @Test
    void finish() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);
        assignment.finish();
        LocalDateTime date = LocalDateTime.now();
        assertNotEquals(date, assignment.getEndDate());
        assertEquals(date.getYear(), assignment.getEndDate().getYear());
        assertEquals(date.getMonth(), assignment.getEndDate().getMonth());
        assertEquals(date.getDayOfMonth(), assignment.getEndDate().getDayOfMonth());
    }

    @Test
    void getService() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);
        assertEquals(test, assignment.getService());
    }

    @Test
    void setService() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("Service numero dos", StructureType.POLE);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);
        assertEquals(test, assignment.getService());
        assignment.setService(test2);
        assertNotEquals(test, assignment.getService());
        assertEquals(test2, assignment.getService());

        assertThrows(NullPointerException.class, ()->{ assignment.setService(null); });
        assertThrows(NullPointerException.class, ()->{ assignment.setService((Structure) null); });
    }

    @Test
    void getHospitalization() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);

        assertEquals(hospitalization, assignment.getHospitalization());
    }

    @Test
    void setHospitalization() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("Service numero dos", StructureType.POLE);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);
        Hospitalization hospitalization2 = new Hospitalization(test2, dmp);

        Assignment assignment = new Assignment(test, hospitalization);

        assertEquals(hospitalization, assignment.getHospitalization());
        assignment.setHospitalization(hospitalization2);
        assertEquals(hospitalization2, assignment.getHospitalization());
        assertNotEquals(hospitalization, assignment.getHospitalization());

        assertThrows(NullPointerException.class, ()->{ assignment.setHospitalization(null); });
        assertThrows(NullPointerException.class, ()->{ assignment.setHospitalization((Hospitalization) null); });
    }

    @Test
    void getAndAddActs() {
        Structure test = new Structure("Hopitalzer", StructureType.HOSPITAL);
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        Assignment assignment = new Assignment(test, hospitalization);

        assertEquals(0, assignment.getActs().size());
        assertThrows(NullPointerException.class, () -> {assignment.addAct(null);});
        assertThrows(NullPointerException.class, () -> {assignment.addAct((Act) null);});

        Act act1 = new Act();
        Act act2 = new Act();
        Act act3 = new Act();

        assignment.addAct(act1);
        assignment.addAct(act2);
        assignment.addAct(act3);
        assertEquals(3, assignment.getActs().size());
        assertEquals(act1, assignment.getActs().get(0));
        assertEquals(act2, assignment.getActs().get(1));
        assertEquals(act3, assignment.getActs().get(2));
    }
}
