package app.restaurantapp.utils.exceptions;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException(Long id) {
        super("No such ratings founded - Restaurant ID: "+ id);
    }
}
