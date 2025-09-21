package org.example.domain.usecase.users;

import jakarta.inject.Named;
import org.example.domain.contracts.UserRepository;
import org.example.domain.model.User;


@Named
public class SaveUserUseCase {
    private final UserRepository userRepository;

    public SaveUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}