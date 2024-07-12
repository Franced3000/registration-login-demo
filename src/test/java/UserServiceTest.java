import org.example.registrationlogindemo.RegistrationLoginDemoApplication;
import org.example.registrationlogindemo.dto.UserDto;
import org.example.registrationlogindemo.entity.User;
import org.example.registrationlogindemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RegistrationLoginDemoApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testGetAllUsers() {
        List<UserDto> users = userService.findAllUsers();
        assertNotNull(users);
        assertTrue(users.size() > 0, "ciao");
    }

    @Test
    public void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setPassword("password");

        Optional<User> createdUser = userService.saveUser(userDto);
        assertNotNull(createdUser);
        assertTrue(createdUser.isPresent());
        assertEquals("John Doe", createdUser.get().getName());
        assertEquals("john.doe@example.com", createdUser.get().getEmail());
        assertTrue(passwordEncoder.matches("password", createdUser.get().getPassword()));
    }
}
