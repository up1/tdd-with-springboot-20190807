package com.example.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() {
        UserResponse expected = new UserResponse();
        expected.setId(1);
        expected.setName("somkiat");
        expected.setEmail("somkiat.p@gmail.com");
        
        UserResponse response 
        = restTemplate.getForObject("/user/1", UserResponse.class);
        
        assertEquals(1, response.getId());
        assertEquals("somkiat", response.getName());
        assertEquals("somkiat.p@gmail.com", response.getEmail());
        assertEquals(expected,  response);
    }

}
