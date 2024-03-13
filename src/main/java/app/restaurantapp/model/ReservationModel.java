package app.restaurantapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESERVATIONS")

public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantModel restaurant;

    @Column(name = "RESERVATION_DATE")
    private LocalDate reservationDate;

    @Column(name = "RESERVATION_HOUR")
    private Integer reservationHour;

    @Column(name = "RESERVATION_STATUS")
    private ReservationStatus reservationStatus;

    @Column(name = "SEATS_NUMBER")
    private Integer seatsNumber;

    @Column(name = "TABLES_NUMBER")
    private Integer tablesNumber;

}
