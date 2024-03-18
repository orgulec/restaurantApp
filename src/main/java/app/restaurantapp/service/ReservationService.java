package app.restaurantapp.service;

import app.restaurantapp.dto.ReservationDto;
import app.restaurantapp.model.ReservationModel;
import app.restaurantapp.model.ReservationStatus;
import app.restaurantapp.model.RestaurantModel;
import app.restaurantapp.model.UserModel;
import app.restaurantapp.repository.ReservationRepository;
import app.restaurantapp.utils.exceptions.NotEnoughSeatsForReservationException;
import app.restaurantapp.utils.exceptions.ReservationTimeAndDateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RestaurantService restaurantService;
    private final UserService userService;
//    private final ReservationMapper reservationMapper;

    public List<ReservationModel> getAllReservationsById(Long id) {
        RestaurantModel restaurant = restaurantService.getRestaurantById(id);
        return reservationRepository.findAllByRestaurant_Id(restaurant.getId());
    }

    public List<ReservationModel> getAllReservationsByIdAndDate(Long id, LocalDate date) {
        RestaurantModel restaurant = restaurantService.getRestaurantById(id);
        return reservationRepository.findAllByRestaurantAndReservationDate(restaurant, date);
    }

    public ReservationModel addNewReservation(ReservationDto reservation) {
        RestaurantModel restaurant = restaurantService.getRestaurantById(reservation.getRestaurantId());
        UserModel guest = userService.getUserById(reservation.getUserId());
        var Seats = new Object() {
            Integer seatsLeft = restaurant.getSeatsNumber();
            Integer tablesLeft = restaurant.getTablesNumber();
        };

        List<ReservationModel> allReservationsByDate = getAllReservationsByIdAndDate(restaurant.getId(), reservation.getReservationDate());
        allReservationsByDate.forEach(System.out::println);

        allReservationsByDate.forEach(res -> {
            if (Objects.equals(res.getReservationHour(), reservation.getReservationHour())) {
                Seats.seatsLeft -= res.getSeatsNumber();
                Seats.tablesLeft -= res.getTablesNumber();
            }
        });

        if (Seats.seatsLeft < restaurant.getSeatsNumber() || Seats.tablesLeft < reservation.getTablesNumber()) {
            throw new NotEnoughSeatsForReservationException();
        }
        if(reservation.getReservationHour() >= restaurant.getOpenToHour()-1){
            throw new ReservationTimeAndDateException("This hour is too late for reservation");
        }

        ReservationModel newReservation = new ReservationModel();
        newReservation.setUser(guest);
        newReservation.setRestaurant(restaurant);
        newReservation.setReservationDate(reservation.getReservationDate());
        newReservation.setReservationHour(reservation.getReservationHour());
        newReservation.setSeatsNumber(reservation.getSeatsNumber());
        newReservation.setTablesNumber(reservation.getTablesNumber());
        newReservation.setReservationStatus(ReservationStatus.WAITING);

        return reservationRepository.save(newReservation);
    }
}
