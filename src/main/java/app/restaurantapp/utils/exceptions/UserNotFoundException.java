package app.restaurantapp.utils.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("No such user founded - ID: "+ userId);
    }
}
