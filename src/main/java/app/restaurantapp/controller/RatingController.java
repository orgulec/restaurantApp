package app.restaurantapp.controller;

import app.restaurantapp.dto.RatingDto;
import app.restaurantapp.model.RatingModel;
import app.restaurantapp.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @Secured("USER")
    @PostMapping("/addRating")
    public ResponseEntity<RatingModel> addRating(@RequestBody RatingDto rating){
        return ResponseEntity.ok(ratingService.addRatingToRestaurant(rating));
    }

    @Secured({"USER","ROLE_ADMIN"})
    @GetMapping("/getRatings/{id}")
    public ResponseEntity<List<RatingModel>> getRatingsByRestaurant(@PathVariable Long id){
        return ResponseEntity.ok(ratingService.getRatingsByRestaurantId(id));
    }

}