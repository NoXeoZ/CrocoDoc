package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.DMP;
import com.crocodoc.crocodocartifact.model.Hospitalization;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.StructureType;
import com.crocodoc.crocodocartifact.repository.HospitalizationRepository;
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
public class HospitalizationTest {

    @MockBean
    private HospitalizationRepository hospitalizationRepository;

    @MockBean
    private DMPResource hospitalizationResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        DMP dmp=new DMP("test","test",new Date(),"test","test","test","test");
        Structure s=new Structure("test", StructureType.HOSPITAL);
        List<Hospitalization> P=new ArrayList<Hospitalization>();
        P.add(new Hospitalization(s,dmp));
        P.add(new Hospitalization(s,dmp));
        P.add(new Hospitalization(s,dmp));
        Hospitalization p= P.get(0);
        Mockito.when(hospitalizationResource.getAllHospitalizationForDMP("test",1L)).thenReturn(P);
        List<Hospitalization> hospitalizations = this.restTemplate.getForObject("http://localhost:" + port + "/dmp/hospitalizations/test/1",
                List.class);
        assertEquals(3, hospitalizations.size());
    }

    @Test
    public void getOne() {
        DMP dmp=new DMP("test","test",new Date(),"test","test","test","test");
        Structure s=new Structure("test", StructureType.HOSPITAL);
        Hospitalization P=new Hospitalization(s,dmp);
        Mockito.when(hospitalizationResource.getHospitalization("test",1L)).thenReturn(java.util.Optional.of(P));
        Hospitalization p2=this.restTemplate.getForObject("http://localhost:" + port + "/dmp/hospitalization/test/1", Hospitalization.class);
        System.out.println(P.getHospital().getName());
        System.out.println(p2.getHospital().getName());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getHospital(),p2.getHospital());
    }

    /*@Test
    public void create() {
        DMP dmp=new DMP("test","test",new Date(),"test","test","test","test");
        Structure s=new Structure("test", StructureType.HOSPITAL);
        Hospitalization P=new Hospitalization(s,dmp);
        Mockito.when(hospitalizationResource.createHospitalization("test", P)).thenReturn(P);
        Hospitalization p2=this.restTemplate.postForObject("http://localhost:" + port + "/dmp/hospitalization/create/test", P, Hospitalization.class);
        System.out.println(P.getHospital().getName());
        System.out.println(p2.getHospital().getName());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getHospital(),p2.getHospital());
    }*/
}
