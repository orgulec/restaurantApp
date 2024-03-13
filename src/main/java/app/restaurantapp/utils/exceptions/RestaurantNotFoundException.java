package app.restaurantapp.utils.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long id){
        super("No such restaurant dounded - ID: " + id);
    }
}
