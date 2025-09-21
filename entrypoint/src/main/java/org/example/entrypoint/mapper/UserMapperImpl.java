package org.example.entrypoint.mapper;

import org.example.domain.model.User;
import org.example.entrypoint.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toDomain(UserDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }

    @Override
    public UserDto toDto(User domain) {
        if (domain == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(domain.getId());
        dto.setFirstName(domain.getFirstName());
        dto.setLastName(domain.getLastName());
        dto.setEmail(domain.getEmail());
        return dto;
    }
}
