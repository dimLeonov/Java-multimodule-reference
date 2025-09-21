package org.example.repository.mapper;

import org.example.domain.model.User;
import org.example.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between User domain model and UserEntity.
 */
@Component
public class UserMapper {
    
    /**
     * Convert a domain model to a JPA entity.
     *
     * @param user the domain model
     * @return the JPA entity
     */
    public UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .createdAt(user.getCreatedAt())
                .build();
    }
    
    /**
     * Convert a JPA entity to a domain model.
     *
     * @param entity the JPA entity
     * @return the domain model
     */
    public User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return User.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}