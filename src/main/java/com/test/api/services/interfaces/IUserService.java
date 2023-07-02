package com.test.api.services.interfaces;

import com.test.api.dto.UserDTO;
import com.test.api.exceptions.user.UserAlreadyExistException;
import com.test.api.exceptions.user.UserNotFoundException;
import com.test.api.models.User;

public interface IUserService {
    UserDTO registration(User user) throws UserAlreadyExistException;
    Long delete(Long id);
    Long update(User newUser);
    UserDTO getById(Long id) throws UserNotFoundException;
    UserDTO getByName(String name) throws UserNotFoundException;
}
