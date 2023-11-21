package backend.housekeeper.houseelegantservice.domain.model.aggregates;

import backend.housekeeper.houseelegantservice.domain.model.valueobjects.HouseStatus;
import backend.housekeeper.houseelegantservice.domain.model.valueobjects.StreetAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
public class House {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country"))
    })
    private StreetAddress address;

    @Column(name = "price")
    private Float price;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private HouseStatus status;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    public House(String street, String city, String country, Float price, String photoUrl, Integer capacity, Float rating) {
        this.address = new StreetAddress(street, city, country);
        this.price = price;
        this.rating = rating;
        this.photoUrl = photoUrl;
        this.capacity = capacity;
        this.status = HouseStatus.FREE;
    }

    public String getStreetAddress() {
        return this.address.getStreetAddress();
    }
}
