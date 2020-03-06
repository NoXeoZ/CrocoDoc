package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.StructureType;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
import com.crocodoc.crocodocartifact.resource.StructureResource;
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
public class StructureTest {

    @MockBean
    private StructureRepository structureRepository;

    @MockBean
    private StructureResource structureResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Structure> P=new ArrayList<Structure>();
        P.add(new Structure("blabla",StructureType.HOSPITAL));
        P.add(new Structure("blabla",StructureType.HOSPITAL));
        P.add(new Structure("blabla",StructureType.HOSPITAL));
        Structure p= P.get(0);
        Mockito.when(structureResource.getAll("test")).thenReturn(P);
        List<Structure> structures = this.restTemplate.getForObject("http://localhost:" + port + "/structures/test",
                List.class);
        assertEquals(3, structures.size());
    }

    @Test
    public void getOne() {
        Structure P=new Structure("gneugneu",StructureType.HOSPITAL);
        Mockito.when(structureResource.getOne("test",1L)).thenReturn(P);
        Structure p2=this.restTemplate.getForObject("http://localhost:" + port + "/structures/test/1", Structure.class);
        assertEquals(P.getName(),p2.getName());
        assertEquals(P.getType(),p2.getType());
        assertEquals(P.getId(),p2.getId());
    }

    @Test
    public void put() {
        Structure P=new Structure("gneugneu",StructureType.HOSPITAL);
        Mockito.when(structureResource.put("test", 1L, P)).thenReturn(P);
        Structure p2=this.restTemplate.postForObject("http://localhost:" + port + "/structures/test/1", P, Structure.class);
        assertEquals(P.getName(),p2.getName());
        assertEquals(P.getType(),p2.getType());
        assertEquals(P.getId(),p2.getId());
    }

    /*@Test
    public void deleteStructure() {
        Structure P=new Structure("gneugneu",StructureType.HOSPITAL);
        Mockito.when(structureRepository.findById(1L)).thenReturn(Optional.of(P));
        Mockito.doNothing().when(structureRepository).delete(P);
        Structure p2=this.restTemplate.exchange("http://localhost:" + port + "/structures/1", HttpMethod.DELETE, null, Structure.class).getBody();
        assertEquals(P.getNom(),p2.getNom());
        assertEquals(P.getPrenom(),p2.getPrenom());
        assertEquals(1,p2.getId());
    }*/

    /*@Test
    public void updateStructure() {
        Structure P=new Structure("gneugneu",StructureType.HOSPITAL);
        Mockito.when(structureRepository.findById(1L)).thenReturn(P);
        Mockito.when(structureRepository.save(P)).thenReturn(P);
        Structure p2=this.restTemplate.getForObject("http://localhost:" + port + "/structures/1", Structure.class);
        assertEquals(P.getNom(),p2.getNom());
        assertEquals(P.getPrenom(),p2.getPrenom());
        assertEquals(1,p2.getId());
    }*/
}
