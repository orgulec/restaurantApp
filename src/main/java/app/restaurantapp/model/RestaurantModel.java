package app.restaurantapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("user")
@Table(name = "RESTAURANTS")
public class RestaurantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "NAME", length = 128)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonManagedReference("user")
    private UserModel owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonBackReference("address")
    private Address address;

    @Column(name = "TYPE")
    private KitchenType kitchenType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SEATS_NUMBER")
    private Integer seatsNumber;

    @Column(name = "TABLES_NUMBER")
    private Integer tablesNumber;

    @Column(name = "OPEN_FROM")
    private Integer openFromHour;
    @Column(name = "OPEN_TO")
    private Integer openToHour;

    @Column(name = "PHONE", length = 12)
    private String phoneNumber;

//    @Column(name = "RATINGS")
//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonBackReference("ratings")
//    private List<RatingModel> ratings = new ArrayStack<>();

}
