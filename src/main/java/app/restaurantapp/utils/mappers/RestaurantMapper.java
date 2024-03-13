package app.restaurantapp.utils.mappers;

import app.restaurantapp.dto.RestaurantDto;
import app.restaurantapp.model.RestaurantModel;
import lombok.Getter;
import org.springframework.stereotype.Component;
@Getter
@Component
public class RestaurantMapper {

    public RestaurantDto toDto(RestaurantModel model){
        RestaurantDto dto = new RestaurantDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setOwner(model.getOwner().getId());
        dto.setAddress(model.getAddress());
        dto.setKitchenType(model.getKitchenType());
        dto.setOpenFromHour(model.getOpenFromHour());
        dto.setOpenToHour(model.getOpenToHour());
        dto.setSeatsNumber(model.getSeatsNumber());
        dto.setTablesNumber(model.getTablesNumber());
        dto.setPhoneNumber(model.getPhoneNumber());
        return dto;
    }

    public RestaurantModel toModel(RestaurantDto dto){
        RestaurantModel entity = new RestaurantModel();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
//        entity.setOwner(dto.getOwner());
        entity.setAddress(dto.getAddress());
        entity.setKitchenType(dto.getKitchenType());
        entity.setOpenFromHour(dto.getOpenFromHour());
        entity.setOpenToHour(dto.getOpenToHour());
        entity.setSeatsNumber(dto.getSeatsNumber());
        entity.setTablesNumber(dto.getTablesNumber());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }
}
