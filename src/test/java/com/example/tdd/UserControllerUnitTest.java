package com.example.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void test03() {
        // Stub
        User somkiat = new User();
        somkiat.setId(1);
        somkiat.setName("somkiat");
        somkiat.setEmail("somkiat.p@gmail.com");

        given(this.userRepository.findById(1))
        .willReturn(Optional.of(somkiat));

        // Act
        UserController controller = new UserController(userRepository);
        UserResponse response = controller.getUser(1);

        // Assert
        assertEquals(1, response.getId());
        assertEquals("somkiat", response.getName());
        assertEquals("somkiat.p@gmail.com", response.getEmail());

    }

}
