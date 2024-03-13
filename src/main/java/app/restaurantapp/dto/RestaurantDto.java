package app.restaurantapp.dto;

import app.restaurantapp.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class RestaurantDto {

    private Long id;
    private String name;
    private Long owner;
//    private UserModel owner;
    private Address address;
    private KitchenType kitchenType;
    private String description;
    private Integer seatsNumber;
    private Integer tablesNumber;
    private String openFromHour;
    private String openToHour;
    private String phoneNumber;
    private Set<RatingModel> ratings;

    @Override
    public String toString() {
        return "RestaurantDto{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                ", address=" + address +
                ", kitchenType=" + kitchenType +
                ", description='" + description + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", tablesNumber=" + tablesNumber +
                ", openFromHour='" + openFromHour + '\'' +
                ", openToHour='" + openToHour + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
