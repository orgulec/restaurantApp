package app.restaurantapp.utils.mappers;

import app.restaurantapp.dto.UserDto;
import app.restaurantapp.model.UserModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UserMapper {

    public UserDto toDto(UserModel model){
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setUsername(model.getUsername());
        dto.setRestaurantOwner(model.isRestaurantOwner());
        if(model.getRestaurant()!=null) dto.setRestaurant(model.getRestaurant().getId());
        return dto;
    }

}
