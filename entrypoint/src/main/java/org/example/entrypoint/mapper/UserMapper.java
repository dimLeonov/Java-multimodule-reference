package org.example.entrypoint.mapper;

import org.example.domain.model.User;
import org.example.entrypoint.dto.UserDto;

public interface UserMapper {
    User toDomain(UserDto dto);
    UserDto toDto(User domain);
}

