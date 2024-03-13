package app.restaurantapp.utils.exceptions;

public class NotEnoughSeatsForReservationException extends RuntimeException {
    public NotEnoughSeatsForReservationException(){
        super("Not enough free seats or tables in that date.");
    }
}
