package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.repository.AssignmentRepository;
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
public class AssignmentTest {

    @MockBean
    private AssignmentRepository assignmentRepository;

    @MockBean
    private DMPResource assignmentResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        DMP dmp = new DMP("test", "test", new Date(), "test", "test", "test", "test");
        Structure s = new Structure("test", StructureType.HOSPITAL);
        Hospitalization h = new Hospitalization(s, dmp);
        List<Assignment> P = new ArrayList<Assignment>();
        P.add(new Assignment(s, h));
        P.add(new Assignment(s, h));
        P.add(new Assignment(s, h));
        Assignment p = P.get(0);
        Mockito.when(assignmentResource.getAllAssignmentsForHospitalization("test", 1L)).thenReturn(P);
        List<Assignment> assignments = this.restTemplate.getForObject("http://localhost:" + port + "/dmp/hospitalization/assignments/test/1",
                List.class);
        assertEquals(3, assignments.size());
    }

    /*@Test
    public void getOne() {
        DMP dmp = new DMP("test", "test", new Date(), "test", "test", "test", "test");
        Structure s = new Structure("test", StructureType.HOSPITAL);
        Hospitalization h = new Hospitalization(s, dmp);
        Assignment P = new Assignment(s, h);
        Mockito.when(assignmentResource.getOneAssignment("test", 1L)).thenReturn(java.util.Optional.of(P));
        Assignment p2 = this.restTemplate.getForObject("http://localhost:" + port + "/dmp/hospitalization/assignment/test/1", Assignment.class);
        assertEquals(P.getId(), p2.getId());
    }*/

    /*@Test
    public void create() {
        DMP dmp=new DMP("test","test",new Date(),"test","test","test","test");
        Structure s=new Structure("test", StructureType.HOSPITAL);
        Assignment P=new Assignment(s,dmp);
        Mockito.when(assignmentResource.createAssignment("test", P)).thenReturn(P);
        Assignment p2=this.restTemplate.postForObject("http://localhost:" + port + "/dmp/assignment/create/test", P, Assignment.class);
        System.out.println(P.getHospital().getName());
        System.out.println(p2.getHospital().getName());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getHospital(),p2.getHospital());
    }*/
}