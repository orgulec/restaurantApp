package app.restaurantapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STREET", length = 128)
    private String street;
    @Column(name = "NUMBER", length = 128)
    private String number;
    @Column(name = "CITY", length = 128)
    private String city;
    @Column(name = "ZIP_CODE", length = 128)
    private String zipCode;
    @Column(name = "COUNTRY", length = 128)
    private String country;
}
