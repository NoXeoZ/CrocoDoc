package com.crocodoc.crocodocartifact.model;

import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getFirstname() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "addresszer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("Cyril", user.getFirstname());
        assertNotEquals("Cyril ", user.getFirstname());
        assertNotEquals("Cyrïl", user.getFirstname());
        assertNotEquals("cyril", user.getFirstname());
    }

    @Test
    void setFirstname() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Boo", "Harranger", new Date(System.currentTimeMillis()), "addresszer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        user.setFirstname("Cyril");
        assertEquals("Cyril", user.getFirstname());
        assertNotEquals("Cyril ", user.getFirstname());
        assertNotEquals("Cyrïl", user.getFirstname());
        assertNotEquals("cyril", user.getFirstname());

        assertThrows(NullPointerException.class, ()->{ user.setFirstname(null);});
        assertThrows(NullPointerException.class, ()->{ user.setFirstname((String) null);});
    }

    @Test
    void getLastname() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "addresszer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("Harranger", user.getLastname());
        assertNotEquals("Harranger ", user.getLastname());
        assertNotEquals("Hàrranger", user.getLastname());
        assertNotEquals("Haranger", user.getLastname());
    }

    @Test
    void setLastname() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Boo", new Date(System.currentTimeMillis()), "addresszer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        user.setLastname("Harranger");
        assertEquals("Harranger", user.getLastname());
        assertNotEquals("Harranger ", user.getLastname());
        assertNotEquals("Hàrranger", user.getLastname());
        assertNotEquals("Haranger", user.getLastname());

        assertThrows(NullPointerException.class, ()->{ user.setLastname(null);});
        assertThrows(NullPointerException.class, ()->{ user.setLastname((String) null);});
    }

    @Test
    void getBirthDate() {
        Date birth = new Date(System.currentTimeMillis());
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", birth, "addresszer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals(birth, user.getBirthDate());
        birth = Date.valueOf("2019-02-09");
        assertNotEquals(birth, user.getBirthDate());
    }

    @Test
    void setBirthDate() {
        Date birth = new Date(System.currentTimeMillis());
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", Date.valueOf("2019-02-09"), "addresszer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        user.setBirthDate(birth);
        assertEquals(birth, user.getBirthDate());
        assertNotEquals(Date.valueOf("2019-02-09"), user.getBirthDate());

        assertThrows(NullPointerException.class, ()->{ user.setBirthDate(null);});
        assertThrows(NullPointerException.class, ()->{ user.setBirthDate((Date) null);});
    }

    @Test
    void getAddress() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("address_zer", user.getAddress());
        assertNotEquals("addresszer ", user.getAddress());
        assertNotEquals("address-zer", user.getAddress());
        assertNotEquals("addresszer ", user.getAddress());
    }

    @Test
    void setAddress() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "boo", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        user.setAddress("address_zer");
        assertEquals("address_zer", user.getAddress());
        assertNotEquals("addresszer ", user.getAddress());
        assertNotEquals("address-zer", user.getAddress());
        assertNotEquals("addresszer ", user.getAddress());

        assertThrows(NullPointerException.class, ()->{ user.setAddress(null);});
        assertThrows(NullPointerException.class, ()->{ user.setAddress((String) null);});
    }

    @Test
    void getPhoneNumber() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("phone-number", user.getPhoneNumber());
        assertNotEquals("phone-number ", user.getPhoneNumber());
        assertNotEquals("phone_number", user.getPhoneNumber());
        assertNotEquals("phone-numbeR", user.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "fdp", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        user.setPhoneNumber("phone-number");
        assertEquals("phone-number", user.getPhoneNumber());
        assertNotEquals("phone-number ", user.getPhoneNumber());
        assertNotEquals("phone_number", user.getPhoneNumber());
        assertNotEquals("phone-numbeR", user.getPhoneNumber());

        assertThrows(NullPointerException.class, ()->{ user.setPhoneNumber(null);});
        assertThrows(NullPointerException.class, ()->{ user.setPhoneNumber((String) null);});
    }

    @Test
    void getEmail() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("email@gmail.fe", user.getEmail());
        assertNotEquals("email@gmail,fe", user.getEmail());
        assertNotEquals("email@gmail.fr", user.getEmail());
        assertNotEquals(" email@gmail.fe", user.getEmail());
    }

    @Test
    void setEmail() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "boo", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        user.setEmail("email@gmail.fe");
        assertEquals("email@gmail.fe", user.getEmail());
        assertNotEquals("email@gmail,fe", user.getEmail());
        assertNotEquals("email@gmail.fr", user.getEmail());
        assertNotEquals(" email@gmail.fe", user.getEmail());

        assertThrows(NullPointerException.class, ()->{ user.setEmail(null);});
        assertThrows(NullPointerException.class, ()->{ user.setEmail((String) null);});
    }

    @Test
    void getPassword() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("passwor^d*9851", user.getPassword());
        assertNotEquals("passwor^d*0851", user.getPassword());
        assertNotEquals("passwor¨d*9851", user.getPassword());
        assertNotEquals(" passwor^d*9851", user.getPassword());
    }

    @Test
    void setPassword() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "paszdz", "R.I.B", UserType.DOCTOR, test);
        user.setPassword("passwor^d*9851");
        assertEquals("passwor^d*9851", user.getPassword());
        assertNotEquals("passwor^d*0851", user.getPassword());
        assertNotEquals("passwor¨d*9851", user.getPassword());
        assertNotEquals(" passwor^d*9851", user.getPassword());

        assertThrows(NullPointerException.class, ()->{ user.setPassword(null);});
        assertThrows(NullPointerException.class, ()->{ user.setPassword((String) null);});
    }

    @Test
    void getRIB() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "R.I.B", UserType.DOCTOR, test);
        assertEquals("R.I.B", user.getRIB());
        assertNotEquals("R.I.B ", user.getRIB());
        assertNotEquals("R,I.B", user.getRIB());
        assertNotEquals("R.i.B", user.getRIB());
    }

    @Test
    void setRIB() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        user.setRIB("R.I.B");
        assertEquals("R.I.B", user.getRIB());
        assertNotEquals("R.I.B ", user.getRIB());
        assertNotEquals("R,I.B", user.getRIB());
        assertNotEquals("R.i.B", user.getRIB());

        assertThrows(NullPointerException.class, ()->{ user.setRIB(null);});
        assertThrows(NullPointerException.class, ()->{ user.setRIB((String) null);});
    }

    @Test
    void getType() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        assertEquals(UserType.DOCTOR, user.getType());
        assertEquals(3, user.getType().getId());
        assertNotEquals(2, user.getType().getId());
        assertNotEquals(UserType.ADMIN, user.getType());
    }

    @Test
    void setType() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        user.setType(UserType.ADMIN);
        assertNotEquals(UserType.DOCTOR, user.getType());
        assertNotEquals(2, user.getType().getId());
        assertEquals(5, user.getType().getId());
        assertEquals(UserType.ADMIN, user.getType());

        assertThrows(NullPointerException.class, ()->{ user.setType(null);});
        assertThrows(NullPointerException.class, ()->{ user.setType((UserType) null);});
    }

    @Test
    void getStructure() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("Service de Test", StructureType.SERVICE);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);

        assertEquals(test, user.getStructure());
        assertNotEquals(test2, user.getStructure());
    }

    @Test
    void setStructure() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        Structure test2 = new Structure("Service de Test", StructureType.SERVICE);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);

        user.setStructure(test2);
        assertNotEquals(test, user.getStructure());
        assertEquals(test2, user.getStructure());

        assertThrows(NullPointerException.class, ()->{ user.setStructure(null);});
        assertThrows(NullPointerException.class, ()->{ user.setStructure((Structure) null);});
    }

    @Test
    void getSpecialities() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        assertEquals(0, user.getSpecialities().size());
    }

    @Test
    void addSpeciality() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        Speciality spe1 = new Speciality("Spécialité 1", "Petite description tu coco");
        Speciality spe2 = new Speciality("Spécialité 2", "Petite description tu coco");
        Speciality spe3 = new Speciality("Spécialité 3", "Petite description tu coco");

        user.addSpeciality(spe1);
        user.addSpeciality(spe2);
        user.addSpeciality(spe3);

        assertEquals(3, user.getSpecialities().size());
        assertTrue(user.getSpecialities().contains(spe1));
        assertTrue(user.getSpecialities().contains(spe2));
        assertTrue(user.getSpecialities().contains(spe3));

        assertThrows(NullPointerException.class, ()->{ user.addSpeciality(null);});
        assertThrows(NullPointerException.class, ()->{ user.addSpeciality((Speciality) null);});
    }

    @Test
    void removeSpeciality() {
        Structure test = new Structure("Hôpitalzer", StructureType.HOSPITAL);
        User user = new User("Cyril", "Harranger", new Date(System.currentTimeMillis()), "address_zer", "phone-number", "email@gmail.fe", "passwor^d*9851", "dazdza.B", UserType.DOCTOR, test);
        Speciality spe1 = new Speciality("Spécialité 1", "Petite description tu coco");
        Speciality spe2 = new Speciality("Spécialité 2", "Petite description tu coco");
        Speciality spe3 = new Speciality("Spécialité 3", "Petite description tu coco");

        user.addSpeciality(spe1);
        user.addSpeciality(spe2);
        user.addSpeciality(spe3);

        user.removeSpeciality(spe2);
        assertEquals(2, user.getSpecialities().size());
        assertFalse(user.getSpecialities().contains(spe2));
        assertTrue(user.getSpecialities().contains(spe1));
        assertTrue(user.getSpecialities().contains(spe3));

        assertThrows(NullPointerException.class, ()->{ user.removeSpeciality(null);});
        assertThrows(NullPointerException.class, ()->{ user.removeSpeciality((Speciality) null);});
    }
}
