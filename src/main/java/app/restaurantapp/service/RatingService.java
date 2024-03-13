package app.restaurantapp.service;

import app.restaurantapp.dto.RatingDto;
import app.restaurantapp.model.RatingModel;
import app.restaurantapp.model.RestaurantModel;
import app.restaurantapp.model.UserModel;
import app.restaurantapp.repository.RatingRepository;
import app.restaurantapp.utils.exceptions.RatingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final RestaurantService restaurantService;
    private final UserService userService;

    public RatingModel addRatingToRestaurant(RatingDto ratingDto) {
        RestaurantModel restaurant = restaurantService.getRestaurantById(ratingDto.getRestaurantId());
        UserModel user = userService.getUserById(ratingDto.getUserId());
        RatingModel newRating = new RatingModel();
        newRating.setRestaurant(restaurant);
        newRating.setUser(user);
        newRating.setRating(ratingDto.getRating());
        newRating.setOpinion(ratingDto.getOpinion());
        return ratingRepository.save(newRating);
    }

    public List<RatingModel> getRatingsByRestaurantId(Long id) {
        RestaurantModel restaurant = restaurantService.getRestaurantById(id);
        List<RatingModel> ratings = ratingRepository.findAllByRestaurant(restaurant);
        if(ratings.isEmpty()){
            throw new RatingNotFoundException(id);
        }
        return ratings;
    }
}
