package app.restaurantapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private boolean restaurantOwner;
    private Long restaurant;


    public void hideLastname(){
        this.setLastName(this.getLastName().charAt(0)+".");
    }

}
