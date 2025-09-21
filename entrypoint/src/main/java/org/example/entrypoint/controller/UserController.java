package org.example.entrypoint.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.domain.model.User;
import org.example.domain.usecase.users.GetUserUseCase;
import org.example.domain.usecase.users.SaveUserUseCase;
import org.example.entrypoint.dto.UserDto;
import org.example.entrypoint.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "the User API")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final GetUserUseCase getUserUseCase;
    private final SaveUserUseCase saveUserUseCase;
    private final UserMapper userMapper;

    public UserController(GetUserUseCase getUserUseCase, SaveUserUseCase saveUserUseCase, UserMapper userMapper) {
        this.getUserUseCase = getUserUseCase;
        this.saveUserUseCase = saveUserUseCase;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Get a user by its id",
            parameters = {
                    @Parameter(name = "id", description = "ID of the user to be obtained", required = true, in = ParameterIn.PATH)
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        log.info("Getting user by id: {}", id);
        return userMapper.toDto(getUserUseCase.execute(Long.parseLong(id)));
    }

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        log.info("Saving user: {}", userDto);
        User user = userMapper.toDomain(userDto);
        return userMapper.toDto(saveUserUseCase.execute(user));
    }
}
