package com.test.api.mappers;

import com.test.api.dto.UserDTO;
import com.test.api.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toModel(UserDTO user);
}
