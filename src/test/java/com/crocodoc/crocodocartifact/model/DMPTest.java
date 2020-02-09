package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class DMPTest {

    @Test
    void getFirstname() {
        DMP dmp = new DMP("Anaëlle", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals("Anaëlle", dmp.getFirstname());
        assertNotEquals("Anaêlle", dmp.getFirstname());
        assertNotEquals("anaëlle", dmp.getFirstname());
    }

    @Test
    void setFirstname() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertThrows(NullPointerException.class, () -> { dmp.setFirstname(null);});
        assertThrows(NullPointerException.class, () -> { dmp.setFirstname((String) null);});

        dmp.setFirstname("Anaëlle");
        assertEquals("Anaëlle", dmp.getFirstname());
        assertNotEquals("Anaêlle", dmp.getFirstname());
        assertNotEquals("anaëlle", dmp.getFirstname());
    }

    @Test
    void getLastname() {
        DMP dmp = new DMP("Anaëlle", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals("TesT", dmp.getLastname());
        assertNotEquals("TèsT", dmp.getLastname());
        assertNotEquals("Test", dmp.getLastname());
    }

    @Test
    void setLastname() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertThrows(NullPointerException.class, () -> { dmp.setLastname(null);});
        assertThrows(NullPointerException.class, () -> { dmp.setLastname((String) null);});

        dmp.setLastname("Anaëlle");
        assertEquals("Anaëlle", dmp.getLastname());
        assertNotEquals("Anaêlle", dmp.getLastname());
        assertNotEquals("anaëlle", dmp.getLastname());
    }

    @Test
    void getBirth() {
        Date birth = new Date(System.currentTimeMillis());
        DMP dmp = new DMP("Cyril", "TesT", birth, "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertEquals(birth, dmp.getBirth());
        birth = Date.valueOf("2019-02-09");
        assertNotEquals(birth, dmp.getBirth());
    }

    @Test
    void setBirth() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        Date birth = Date.valueOf("2019-02-09");
        dmp.setBirth(birth);
        assertEquals(birth, dmp.getBirth());
    }

    @Test
    void getBirthCity() {
        DMP dmp = new DMP("Anaëlle", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals("Paris", dmp.getBirthCity());
        assertNotEquals("Parïs", dmp.getBirthCity());
        assertNotEquals("paris", dmp.getBirthCity());
    }

    @Test
    void setBirthCity() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertThrows(NullPointerException.class, () -> { dmp.setBirthCity(null);});
        assertThrows(NullPointerException.class, () -> { dmp.setBirthCity((String) null);});

        dmp.setBirthCity("Anaëlle");
        assertEquals("Anaëlle", dmp.getBirthCity());
        assertNotEquals("Anaêlle", dmp.getBirthCity());
        assertNotEquals("anaëlle", dmp.getBirthCity());
    }

    @Test
    void getSocialSecurityNumber() {
        DMP dmp = new DMP("Anaëlle", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals("5414548415154", dmp.getSocialSecurityNumber());
        assertNotEquals("5415448415154", dmp.getSocialSecurityNumber());
        assertNotEquals("541454_841515", dmp.getSocialSecurityNumber());
    }

    @Test
    void setSocialSecurityNumber() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertThrows(NullPointerException.class, () -> { dmp.setSocialSecurityNumber(null);});
        assertThrows(NullPointerException.class, () -> { dmp.setSocialSecurityNumber((String) null);});

        dmp.setSocialSecurityNumber("Anaëlle");
        assertEquals("Anaëlle", dmp.getSocialSecurityNumber());
        assertNotEquals("Anaêlle", dmp.getSocialSecurityNumber());
        assertNotEquals("anaëlle", dmp.getSocialSecurityNumber());
    }

    @Test
    void getPhoneNumber() {
        DMP dmp = new DMP("Anaëlle", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals("0645154232", dmp.getPhoneNumber());
        assertNotEquals("0645164232", dmp.getPhoneNumber());
        assertNotEquals("064515@232", dmp.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertThrows(NullPointerException.class, () -> { dmp.setPhoneNumber(null);});
        assertThrows(NullPointerException.class, () -> { dmp.setPhoneNumber((String) null);});

        dmp.setPhoneNumber("Anaëlle");
        assertEquals("Anaëlle", dmp.getPhoneNumber());
        assertNotEquals("Anaêlle", dmp.getPhoneNumber());
        assertNotEquals("anaëlle", dmp.getPhoneNumber());
    }

    @Test
    void getEmail() {
        DMP dmp = new DMP("Anaëlle", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals("email@gmail.com", dmp.getEmail());
        assertNotEquals("email2@gmail.com", dmp.getEmail());
        assertNotEquals("email@gmail.fr", dmp.getEmail());
    }

    @Test
    void setEmail() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");

        assertThrows(NullPointerException.class, () -> { dmp.setEmail(null);});
        assertThrows(NullPointerException.class, () -> { dmp.setEmail((String) null);});

        dmp.setEmail("anaëlle@yahouu.fr");
        assertEquals("anaëlle@yahouu.fr", dmp.getEmail());
        assertNotEquals("anaêlle@yahouu.fr", dmp.getEmail());
        assertNotEquals("aNaëlle@yahouu.fr", dmp.getEmail());
    }

    @Test
    void getAndAddHospitalization() {
        DMP dmp = new DMP("Cyril", "TesT", new Date(System.currentTimeMillis()), "Paris", "5414548415154", "0645154232", "email@gmail.com");
        assertEquals(0, dmp.getHospitalization().size());

        Structure test = new Structure("Hopitalzer", 1);
        Hospitalization hospitalization = new Hospitalization(test, dmp);

        dmp.addHospitalization(hospitalization);
        assertEquals(1, dmp.getHospitalization().size());
        assertEquals(dmp.getFirstname(), dmp.getHospitalization().get(0).getDMP().getFirstname());
        assertEquals(dmp.getLastname(), dmp.getHospitalization().get(0).getDMP().getLastname());
        assertEquals(dmp.getBirth(), dmp.getHospitalization().get(0).getDMP().getBirth());

        Hospitalization hospitalization2 = new Hospitalization(test, dmp);
        dmp.addHospitalization(hospitalization2);
        dmp.setFirstname("COUCOU^zad");
        assertEquals(2, dmp.getHospitalization().size());
        assertEquals(dmp.getFirstname(), dmp.getHospitalization().get(0).getDMP().getFirstname());
        assertEquals(dmp.getLastname(), dmp.getHospitalization().get(0).getDMP().getLastname());
        assertEquals(dmp.getBirth(), dmp.getHospitalization().get(0).getDMP().getBirth());
        assertEquals(dmp.getFirstname(), dmp.getHospitalization().get(1).getDMP().getFirstname());
        assertEquals(dmp.getLastname(), dmp.getHospitalization().get(1).getDMP().getLastname());
        assertEquals(dmp.getBirth(), dmp.getHospitalization().get(1).getDMP().getBirth());
    }
}
