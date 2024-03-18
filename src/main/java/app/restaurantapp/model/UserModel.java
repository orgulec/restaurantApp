package app.restaurantapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("restaurant")
@Table(name = "USERS")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "FIRSTNAME", length = 128, nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", length = 128, nullable = false)
    private String lastName;

    @Column(name = "LOGIN", length = 128, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 128, nullable = false)
    private String password;

    @Column(name = "EMAIL", length = 128, nullable = false)
    private String email;

    @Column(name = "RESTAURANT_OWNER")
    private boolean restaurantOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference("restaurant")
    private RestaurantModel restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return restaurantOwner == userModel.restaurantOwner && Objects.equals(id, userModel.id) && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password) && Objects.equals(email, userModel.email) && Objects.equals(restaurant, userModel.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, email, restaurantOwner, restaurant);
    }
}
