package app.restaurantapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties("restaurant")
@Table(name = "RATINGS")
public class RatingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurants_id")
    @JsonBackReference("restaurant")
    private RestaurantModel restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private UserModel user;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "OPINION")
    private String opinion;


}
