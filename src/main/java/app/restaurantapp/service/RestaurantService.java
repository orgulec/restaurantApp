package app.restaurantapp.service;

import app.restaurantapp.dto.RestaurantDto;
import app.restaurantapp.model.RatingModel;
import app.restaurantapp.model.RestaurantModel;
import app.restaurantapp.model.UserModel;
import app.restaurantapp.repository.RestaurantRepository;
import app.restaurantapp.utils.exceptions.RestaurantNotFoundException;
import app.restaurantapp.utils.exceptions.UserNotPermittedException;
import app.restaurantapp.utils.mappers.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final UserService userService;


    public RestaurantModel getRestaurantById(Long restaurantId) {
        Optional<RestaurantModel> restaurantOpt = restaurantRepository.findById(restaurantId);
        if(restaurantOpt.isEmpty()) {
            throw new RestaurantNotFoundException(restaurantId);
        }
        return restaurantOpt.get();
    }
    public RestaurantDto getRestaurantDtoById(Long restaurantId) {
        Optional<RestaurantModel> restaurantOpt = restaurantRepository.findById(restaurantId);
        if(restaurantOpt.isEmpty()) {
            throw new RestaurantNotFoundException(restaurantId);
        }
        return new RestaurantMapper().toDto(restaurantOpt.get());
    }

    public List<RestaurantDto> getAllRestaurantDtos() {
        List<RestaurantModel> restaurantsList = restaurantRepository.findAll();
        return restaurantsList.stream()
                .map(new RestaurantMapper()::toDto).collect(Collectors.toList());
    }

    public RestaurantModel addNewRestaurant(RestaurantDto restaurantDto) {
        UserModel restaurantOwner = userService.getUserById(restaurantDto.getOwner());
        if(!restaurantOwner.isRestaurantOwner()){
            throw new UserNotPermittedException("User is not permitted to add new restaurant.");
        }
        if(restaurantOwner.getRestaurant()!=null){
            throw new UserNotPermittedException("User already have a restaurant.");
        }
        RestaurantMapper mapper = new RestaurantMapper();
        RestaurantModel newRestaurant = mapper.toModel(restaurantDto);
        newRestaurant.setOwner(restaurantOwner);
        return restaurantRepository.save(newRestaurant);
    }
}
