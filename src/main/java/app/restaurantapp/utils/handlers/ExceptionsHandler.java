package app.restaurantapp.utils.handlers;

import app.restaurantapp.utils.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<String> handleRestaurantNotFoundException(RestaurantNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
    }
    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<String> handleRatingNotFoundException(RatingNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
    }
    @ExceptionHandler(UserNotPermittedException.class)
    public ResponseEntity<String> handleUserNotPermittedException(UserNotPermittedException ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

    @ExceptionHandler(NotEnoughSeatsForReservationException.class)
    public ResponseEntity<String> handleNotEnoughSeatsForReservationException(NotEnoughSeatsForReservationException ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }
    @ExceptionHandler(NoRatingsFoundedException.class)
    public ResponseEntity<String> handleNoRatingsFoundedException(NoRatingsFoundedException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(ReservationTimeAndDateException.class)
    public ResponseEntity<String> handleReservationTimeAndDateException(ReservationTimeAndDateException ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

}
