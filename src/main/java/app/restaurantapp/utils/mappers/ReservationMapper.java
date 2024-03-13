package app.restaurantapp.utils.mappers;

import app.restaurantapp.dto.ReservationDto;
import app.restaurantapp.model.ReservationModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ReservationMapper {

    public ReservationDto toDto(ReservationModel model){
        ReservationDto dto = new ReservationDto();
        dto.setUserId(model.getUser().getId());
        dto.setRestaurantId(model.getRestaurant().getId());
        dto.setReservationDate(model.getReservationDate());
        dto.setReservationHour(model.getReservationHour());
        dto.setSeatsNumber(model.getSeatsNumber());
        dto.setTablesNumber(model.getTablesNumber());
        dto.setReservationStatus(model.getReservationStatus());
        return dto;
    }
    public ReservationModel toEntity(ReservationDto dto){
        ReservationModel entity = new ReservationModel();
        entity.setReservationDate(dto.getReservationDate());
        entity.setReservationHour(dto.getReservationHour());
        entity.setSeatsNumber(dto.getSeatsNumber());
        entity.setTablesNumber(dto.getTablesNumber());
        entity.setReservationStatus(dto.getReservationStatus());
        return entity;
    }
}
