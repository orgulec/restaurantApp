package app.restaurantapp.controller;

import app.restaurantapp.dto.RestaurantDto;
import app.restaurantapp.model.RestaurantModel;
import app.restaurantapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/getAll")
    public ResponseEntity<List<RestaurantDto>> getAll(){
        return ResponseEntity.ok(restaurantService.getAllRestaurantDtos());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RestaurantDto> getAll(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantDtoById(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantModel> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        return ResponseEntity.ok(restaurantService.addNewRestaurant(restaurantDto));
    }

}
