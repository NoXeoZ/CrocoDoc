/*package com.crocodoc.crocodocartifact.ressource;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class structureRessourceTest {
    @LocalServerPort
    private int port;
    @MockBean
    private StructureService structureService;
    @MockBean
    private StructureRepository structureRepository;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAll() {
        List structures = this.restTemplate.getForObject("http://localhost:" + port + "/structures", List.class);
        assertEquals(0, structures.size());
    }

    @Test
    void post() {
        Structure structure = new Structure("structure1",1);
        structure.setId(1L);
        when(structureService.create(structure)).thenReturn(structure);
        Structure result = this.restTemplate.postForObject("http://localhost:" + port + "/structures", structure, Structure.class);
        assertEquals(structure, result);
    }

    @Test
    void getOne() {
        Structure structure = new Structure("structure1",1);
        structure.setId(1L);
        when(structureService.getOne(1L)).thenReturn(Optional.of(structure));
        HttpEntity<Structure> request = new HttpEntity<>(structure);
        this.restTemplate.exchange("http://localhost:" + port + "/structures",
                HttpMethod.POST, request, Structure.class);
        Structure resultGet = this.restTemplate.getForObject("http://localhost:" + port + "/structures/1", Structure.class);
        assertEquals(structure, resultGet);
    }

    @Test
    void delete() {
        /*Structure structure = new Structure("structure1",1);
        structure.setId(1L);
        when(structureService.getOne(1L)).thenReturn(Optional.of(structure));
        HttpEntity<Structure> request = new HttpEntity<>(structure);
        this.restTemplate.exchange("http://localhost:" + port + "/structures", HttpMethod.POST, request, Structure.class);
        List animalListBefore= this.restTemplate.getForObject("http://localhost:" + port + "/structures", List.class);

        doNothing().when(structureRepository).delete(structure);
        Structure result = this.restTemplate.exchange("http://localhost:" + port + "/structures/1",
                HttpMethod.DELETE, null, Structure.class).getBody();
        List animalListAfter = this.restTemplate.getForObject("http://localhost:" + port + "/structures", List.class);
        assertEquals(animalListAfter.size(), animalListBefore.size());*/
  /*  }

    @Test
    void put() {
        Structure structure = new Structure("structure1",1);
        Structure structure2 = new Structure("structure2",2);
        structure.setId(1L);
        structure2.setId(2L);
        when(structureService.create(structure)).thenReturn(structure);
        when(structureService.update(1L, structure2)).thenReturn(structure2);
        this.restTemplate.postForObject("http://localhost:" + port + "/structures", structure, Structure.class);
        HttpEntity<Structure> request = new HttpEntity<>(structure2);
        Structure result = this.restTemplate.exchange("http://localhost:" + port + "/structures/1",
                HttpMethod.POST, request, Structure.class).getBody();
        assertEquals(result, structure2);
    }
}*/
