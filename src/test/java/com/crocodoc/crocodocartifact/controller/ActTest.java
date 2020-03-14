package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.repository.ActRepository;
import com.crocodoc.crocodocartifact.resource.DMPResource;
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
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActTest {

    @MockBean
    private ActRepository actRepository;

    @MockBean
    private DMPResource actResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        DMP dmp = new DMP("test", "test", new Date(), "test", "test", "test", "test");
        Structure s = new Structure("test", StructureType.HOSPITAL);
        Hospitalization h = new Hospitalization(s, dmp);
        User u=new User("test", "test", new Date(), "test", "test", "test", "test", "test", UserType.ADMIN, s);
        Assignment a=new Assignment(s, h);
        List<Act> P = new ArrayList<Act>();

        P.add(new Act(u, ActType.OBSERVATION, a, "test"));
        P.add(new Act(u, ActType.OBSERVATION, a, "test"));
        P.add(new Act(u, ActType.OBSERVATION, a, "test"));
        Act p = P.get(0);
        Mockito.when(actResource.getAllActsForAssignment("test", 1L)).thenReturn(P);
        List<Act> acts = this.restTemplate.getForObject("http://localhost:" + port + "/dmp/hospitalization/assignment/acts/test/1",
                List.class);
        assertEquals(3, acts.size());
    }

    /*@Test
    public void getOne() {
        DMP dmp = new DMP("test", "test", new Date(), "test", "test", "test", "test");
        Structure s = new Structure("test", StructureType.HOSPITAL);
        Hospitalization h = new Hospitalization(s, dmp);
        Act P = new Act(s, h);
        Mockito.when(actResource.getOneAct("test", 1L)).thenReturn(java.util.Optional.of(P));
        Act p2 = this.restTemplate.getForObject("http://localhost:" + port + "/dmp/hospitalization/act/test/1", Act.class);
        assertEquals(P.getId(), p2.getId());
    }*/

    /*@Test
    public void create() {
        DMP dmp=new DMP("test","test",new Date(),"test","test","test","test");
        Structure s=new Structure("test", StructureType.HOSPITAL);
        Act P=new Act(s,dmp);
        Mockito.when(actResource.createAct("test", P)).thenReturn(P);
        Act p2=this.restTemplate.postForObject("http://localhost:" + port + "/dmp/act/create/test", P, Act.class);
        System.out.println(P.getHospital().getName());
        System.out.println(p2.getHospital().getName());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getHospital(),p2.getHospital());
    }*/
}
