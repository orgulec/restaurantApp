package app.restaurantapp.repository;

import app.restaurantapp.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantModel,Long> {
}
