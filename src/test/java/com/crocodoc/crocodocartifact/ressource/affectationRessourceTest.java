package com.crocodoc.crocodocartifact.ressource;
/*
import com.crocodoc.crocodocartifact.model.Affectation;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.repository.AffectationRepository;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
import com.crocodoc.crocodocartifact.service.AffectationService;
import com.crocodoc.crocodocartifact.service.StructureService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class affectationRessourceTest {
    @LocalServerPort
    private int port;
    @MockBean
    private AffectationService affectationService;
    @MockBean
    private AffectationRepository affectationRepository;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAll() {
        List affectations = this.restTemplate.getForObject("http://localhost:" + port + "/affectations", List.class);
        assertEquals(0, affectations.size());
    }

    @Test
    void create() {
       /* Structure structure=new Structure("structure2",5);
        Affectation affectation = new Affectation(structure);
        affectation.setId(1L);
        when(affectationService.create(affectation)).thenReturn(affectation);
        Affectation result = this.restTemplate.postForObject("http://localhost:" + port + "/affectations", affectation, Affectation.class);
        assertEquals(affectation, result);*/
 /*   }*/
/*
    @Test
    void getOne() {
        Structure structure = new Structure("structure1",1);
        Affectation affectation = new Affectation(structure);
        affectation.setId(1L);
        when(affectationService.getOne(1L)).thenReturn(Optional.of(affectation));
        HttpEntity<Affectation> request = new HttpEntity<>(affectation);
        this.restTemplate.exchange("http://localhost:" + port + "/affectations",
                HttpMethod.POST, request, Structure.class);
        Affectation resultGet = this.restTemplate.getForObject("http://localhost:" + port + "/affectations/1", Affectation.class);
        assertEquals(affectation, resultGet);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
        Structure structure = new Structure("structure2",2);
        Affectation affectation = new Affectation(structure);
        Structure structure2 = new Structure("structure1",7);
        Affectation affectation2 = new Affectation(structure2);

        affectation.setId(1L);
        when(affectationService.create(affectation)).thenReturn(affectation);
        when(affectationService.update(1L, affectation2)).thenReturn(affectation2);
        this.restTemplate.postForObject("http://localhost:" + port + "/affectations", structure, Structure.class);
        HttpEntity<Affectation> request = new HttpEntity<>(affectation2);
        Affectation result = this.restTemplate.exchange("http://localhost:" + port + "/affectations/1",
                HttpMethod.POST, request, Affectation.class).getBody();
        assertEquals(result, affectation2);
    }
}*/
