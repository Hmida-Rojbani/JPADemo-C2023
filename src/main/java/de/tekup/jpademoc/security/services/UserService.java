package de.tekup.jpademoc.security.services;

import de.tekup.jpademoc.security.models.Role;
import de.tekup.jpademoc.security.models.User;
import de.tekup.jpademoc.security.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder bcryptPasswordEncoder;

    public void registerUser(User user){
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }
}
