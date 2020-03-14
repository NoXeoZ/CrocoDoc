package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.Speciality;
import com.crocodoc.crocodocartifact.repository.SpecialityRepository;
import com.crocodoc.crocodocartifact.resource.SpecialityResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpecialityTest {

    @MockBean
    private SpecialityRepository specialityRepository;

    @MockBean
    private SpecialityResource specialityResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Speciality> P=new ArrayList<Speciality>();
        P.add(new Speciality("test1","test1"));
        P.add(new Speciality("test2","test2"));
        P.add(new Speciality("test3","test3"));
        Speciality p= P.get(0);
        Mockito.when(specialityResource.getAll("test")).thenReturn(P);
        List<Speciality> specialitys = this.restTemplate.getForObject("http://localhost:" + port + "/specialities/test",
                List.class);
        assertEquals(3, specialitys.size());
    }

    @Test
    public void getOne() {
        Speciality P=new Speciality("test","test");
        Mockito.when(specialityResource.getOne("test",1L)).thenReturn(java.util.Optional.of(P));
        Speciality p2=this.restTemplate.getForObject("http://localhost:" + port + "/specialities/test/1", Speciality.class);
        assertEquals(P.getName(),p2.getName());
        assertEquals(P.getDescription(),p2.getDescription());
        assertEquals(P.getId(),p2.getId());
    }

    @Test
    public void create() {
        Speciality P=new Speciality("test", "test");
        Mockito.when(specialityResource.post("test", P)).thenReturn(P);
        Speciality p2=this.restTemplate.postForObject("http://localhost:" + port + "/specialities/test", P, Speciality.class);
        assertEquals(P.getName(),p2.getName());
        assertEquals(P.getDescription(),p2.getDescription());
        assertEquals(P.getId(),p2.getId());
    }
}
