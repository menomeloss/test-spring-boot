package com.test.api.services;

import com.test.api.dto.UserDTO;
import com.test.api.exceptions.user.UserAlreadyExistException;
import com.test.api.exceptions.user.UserNotFoundException;
import com.test.api.mappers.UserMapper;
import com.test.api.models.User;
import com.test.api.repositories.UserRepo;
import com.test.api.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepo repo;
    private final UserMapper mapper;
    @Override
    public UserDTO registration(User user) throws UserAlreadyExistException {
        if (repo.existsByName(user))
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует.");
        return mapper.toDTO(repo.save(user));
    }
    @Override
    public Long delete(Long id) {
        repo.deleteById(id);
        return id;
    }
    @Override
    public Long update(User newUser) {
        repo.save(newUser);
        return newUser.getId();
    }
    @Override
    public UserDTO getById(Long id) throws UserNotFoundException {
        var user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "Пользователь не найден."));

        return mapper.toDTO(user);

    }

    @Override
    public UserDTO getByName(String name) throws UserNotFoundException {
        var user = repo.findByName(name);
        if (user == null)
            throw new UserNotFoundException(
                    "Пользователь с таким именем не найден.");
        return mapper.toDTO(user);
    }

}
