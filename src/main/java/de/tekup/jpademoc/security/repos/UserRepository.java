package de.tekup.jpademoc.security.repos;

import de.tekup.jpademoc.security.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
