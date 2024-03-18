package app.restaurantapp.controller;

import app.restaurantapp.dto.UserDto;
import app.restaurantapp.model.UserModel;
import app.restaurantapp.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "Endpoints for mapping Users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getUsersDtos(){
        return ResponseEntity.ok(userService.getAllUsersDto());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<UserModel> addUser(@Valid @RequestBody UserModel user){
        return ResponseEntity.ok(userService.createUser(user));
    }

}
