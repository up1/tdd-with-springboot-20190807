package com.example.tdd;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerMvcTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private UserRepository userRepository;

    @Test
    public void test02() throws Exception {
        // Stub
        User somkiat = new User();
        somkiat.setId(1);
        somkiat.setName("somkiat");
        somkiat.setEmail("somkiat.p@gmail.com");
        
        given(this.userRepository.findById(1))
        .willReturn(Optional.of(somkiat));
        
        // Act
        MvcResult result = this.mvc.perform(get("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk()).andReturn();
        
        // Assert
        String resultJson = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        UserResponse response = mapper.readValue(resultJson, UserResponse.class);
        
        assertEquals(1, response.getId());
        assertEquals("somkiat", response.getName());
        assertEquals("somkiat.p@gmail.com", response.getEmail());
    }

}
