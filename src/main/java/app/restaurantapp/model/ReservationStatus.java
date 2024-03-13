package app.restaurantapp.model;

import lombok.Getter;

@Getter
public enum ReservationStatus {
    ACCEPTED,
    REJECTED,
    WAITING,
    CLOSED
}
