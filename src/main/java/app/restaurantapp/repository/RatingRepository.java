package app.restaurantapp.repository;

import app.restaurantapp.model.RatingModel;
import app.restaurantapp.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingModel,Long> {
    List<RatingModel> findAllByRestaurant(RestaurantModel restaurant);


}
