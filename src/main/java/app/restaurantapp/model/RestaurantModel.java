package app.restaurantapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonManagedReference
    private UserModel owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonBackReference("adrs")
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
    private String openFromHour;
    @Column(name = "OPEN_TO")
    private String openToHour;

    @Column(name = "PHONE", length = 12)
    private String phoneNumber;

//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RatingModel> ratings = new ArrayStack<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantModel that = (RestaurantModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(owner, that.owner) && Objects.equals(address, that.address) && kitchenType == that.kitchenType && Objects.equals(description, that.description) && Objects.equals(seatsNumber, that.seatsNumber) && Objects.equals(tablesNumber, that.tablesNumber) && Objects.equals(openFromHour, that.openFromHour) && Objects.equals(openToHour, that.openToHour) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, address, kitchenType, description, seatsNumber, tablesNumber, openFromHour, openToHour, phoneNumber);
    }
}
