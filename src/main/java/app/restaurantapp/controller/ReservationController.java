package app.restaurantapp.controller;

import app.restaurantapp.dto.ReservationDto;
import app.restaurantapp.model.ReservationModel;
import app.restaurantapp.service.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@Tag(name = "Reservation Controller", description = "Endpoints for mapping Reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<List<ReservationModel>> getAllReservationsByRestaurantId(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getAllReservationsById(id));
    }

//    @Secured({"USER","ROLE_ADMIN"})
    @PostMapping("/addNewReservation")
    public ResponseEntity<ReservationModel> addNewReservation(@Valid @RequestBody ReservationDto reservation){
        return ResponseEntity.ok(reservationService.addNewReservation(reservation));
    }

}
