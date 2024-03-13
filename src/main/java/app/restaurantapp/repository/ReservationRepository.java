package app.restaurantapp.repository;

import app.restaurantapp.model.ReservationModel;
import app.restaurantapp.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationModel,Long> {

    List<ReservationModel> findAllByRestaurant_Id(Long id);

    List<ReservationModel> findAllByRestaurantAndReservationDate(RestaurantModel restaurantModel, LocalDate date);


}
