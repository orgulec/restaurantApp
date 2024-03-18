package app.restaurantapp.service;

import app.restaurantapp.dto.UserDto;
import app.restaurantapp.model.UserModel;
import app.restaurantapp.repository.UserRepository;
import app.restaurantapp.utils.exceptions.UserNotFoundException;
import app.restaurantapp.utils.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel getUserById(Long userId) {
        Optional<UserModel> userOpt = userRepository.findById(userId);
        if(userOpt.isEmpty()){
            throw new UserNotFoundException(userId);
        }
        return userOpt.get();
    }

    public List<UserDto> getAllUsersDto() {
        List<UserModel> users = userRepository.findAll();
        List<UserDto> mappedUsers = users.stream()
                .map(new UserMapper()::toDto).collect(Collectors.toList());
        mappedUsers.forEach(UserDto::hideLastname);
        return mappedUsers;
    }


    public UserModel createUser(UserModel user) {
        UserModel newUser = new UserModel();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRestaurantOwner(user.isRestaurantOwner());
        newUser.setRestaurant(user.getRestaurant());
        return userRepository.save(newUser);
    }
}
