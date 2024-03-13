package app.restaurantapp.dto;

import app.restaurantapp.model.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ReservationDto {

    private Long userId;

    private Long restaurantId;

    private LocalDate reservationDate;

    private Integer reservationHour;

    private ReservationStatus reservationStatus;

    private Integer seatsNumber;

    private Integer tablesNumber;
}
