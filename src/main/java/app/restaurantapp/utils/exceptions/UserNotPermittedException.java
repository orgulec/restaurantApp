package app.restaurantapp.utils.exceptions;

public class UserNotPermittedException extends RuntimeException {
    public UserNotPermittedException(String s) {
        super("Not allowed: "+ s);
    }
}
