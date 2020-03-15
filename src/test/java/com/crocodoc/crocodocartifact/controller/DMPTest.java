package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.DMP;
import com.crocodoc.crocodocartifact.repository.DMPRepository;
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
public class DMPTest {

    @MockBean
    private DMPRepository dmpRepository;

    @MockBean
    private DMPResource dmpResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<DMP> P=new ArrayList<DMP>();
        P.add(new DMP("test1","test1",new Date(),"test","test","test","test"));
        P.add(new DMP("test2","test2",new Date(),"test","test","test","test"));
        P.add(new DMP("test3","test3",new Date(),"test","test","test","test"));
        DMP p= P.get(0);
        System.out.println(new Date());
        Mockito.when(dmpResource.getAllDMP("test")).thenReturn(P);
        List<DMP> dmps = this.restTemplate.getForObject("http://localhost:" + port + "/dmps/test",
                List.class);
        assertEquals(3, dmps.size());
    }

    @Test
    public void getOne() {
        DMP P=new DMP("test","test",new Date(),"test","test","test","test");
        Mockito.when(dmpResource.getOneDMP("test",1L)).thenReturn(java.util.Optional.of(P));
        DMP p2=this.restTemplate.getForObject("http://localhost:" + port + "/dmp/test/1", DMP.class);
        assertEquals(P.getEmail(),p2.getEmail());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getBirth(),p2.getBirth());
        assertEquals(P.getBirthCity(),p2.getBirthCity());
        assertEquals(P.getFirstname(),p2.getFirstname());
        assertEquals(P.getLastname(),p2.getLastname());
        assertEquals(P.getPhoneNumber(),p2.getPhoneNumber());
    }

    @Test
    public void create() {
        DMP P=new DMP("test","test",new Date(),"test","test","test","test");
        Mockito.when(dmpResource.createDMP("test", P)).thenReturn(P);
        DMP p2=this.restTemplate.postForObject("http://localhost:" + port + "/dmp/create/test", P, DMP.class);
        assertEquals(P.getEmail(),p2.getEmail());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getBirth(),p2.getBirth());
        assertEquals(P.getBirthCity(),p2.getBirthCity());
        assertEquals(P.getFirstname(),p2.getFirstname());
        assertEquals(P.getLastname(),p2.getLastname());
        assertEquals(P.getPhoneNumber(),p2.getPhoneNumber());
    }
}
