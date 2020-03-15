package com.crocodoc.crocodocartifact.controller;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.StructureType;
import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.model.UserType;
import com.crocodoc.crocodocartifact.repository.UserRepository;
import com.crocodoc.crocodocartifact.resource.UserResource;
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
public class UserTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserResource userResource;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        Structure s=new Structure("test1", StructureType.HOSPITAL);
        List<User> P=new ArrayList<User>();
        P.add(new User("test1", "test1", new Date(), "test", "test", "test", "test", "test", UserType.ADMIN, s));
        P.add(new User("test2", "test2", new Date(), "test", "test", "test", "test", "test", UserType.ADMIN, s));
        P.add(new User("test3", "test3", new Date(), "test", "test", "test", "test", "test", UserType.ADMIN, s));
        User p= P.get(0);
        Mockito.when(userResource.getAll("test")).thenReturn(P);
        List<User> users = this.restTemplate.getForObject("http://localhost:" + port + "/user/test",
                List.class);
        assertEquals(3, users.size());
    }

    @Test
    public void getOne() {
        Structure s=new Structure("test1", StructureType.HOSPITAL);
        User P=new User("test", "test", new Date(), "test", "test", "test", "test", "test", UserType.ADMIN, s);
        Mockito.when(userResource.getOne(1L, "test")).thenReturn(java.util.Optional.of(P));
        User p2=this.restTemplate.getForObject("http://localhost:" + port + "/user/1/test", User.class);
        assertEquals(P.getEmail(),p2.getEmail());
        assertEquals(P.getType(),p2.getType());
        assertEquals(P.getId(),p2.getId());
        assertEquals(P.getFirstname(),p2.getFirstname());
        assertEquals(P.getLastname(),p2.getLastname());
        assertEquals(P.getPassword(),p2.getPassword());
        assertEquals(P.getAddress(),p2.getAddress());
        assertEquals(P.getPhoneNumber(),p2.getPhoneNumber());
        assertEquals(P.getRIB(),p2.getRIB());
        assertEquals(P.getStructure(),p2.getStructure());
        assertEquals(P.getBirthDate(),p2.getBirthDate());
        assertEquals(P.getSpecialities(),p2.getSpecialities());
    }
}

