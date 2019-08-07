package com.example.tdd;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void found_get_data_by_id_1() {
        User somkiat = new User();
        somkiat.setId(1);
        somkiat.setName("somkiat");
        somkiat.setEmail("somkiat.p@gmail.com");
        userRepository.save(somkiat);
        
        Optional<User> found = userRepository.findById(1);
        
        assertTrue(found.isPresent());
        assertEquals(somkiat, found.get());
    }
    
    @Test
    public void not_found_get_data_by_id_1() {
        Optional<User> found = userRepository.findById(1);
        
        assertFalse(found.isPresent());
    }

}
