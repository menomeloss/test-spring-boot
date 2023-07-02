package com.test.api.repositories;

import com.test.api.dto.UserDTO;
import com.test.api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByName(String name);
    Boolean existsByName(User user);
}
