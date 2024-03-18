package app.restaurantapp.utils.exceptions;

public class NoRatingsFoundedException extends RuntimeException {
    public NoRatingsFoundedException(){
        super("No ratings founded.");
    }
}
