package backend.housekeeper.houseelegantservice.domain.model.aggregates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Getter
public class Viaje {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "description") // Puedes personalizar el nombre de la columna si es necesario
    private String description;

    @Column(name = "photo_face") // Puedes personalizar el nombre de la columna si es necesario
    private String photoUrl;

    @Column(name = "rating")
    private Float rating;

    @CreatedDate
    @JsonIgnore
    private Date createdAt;

    @LastModifiedDate
    @JsonIgnore
    private Date updatedAt;

    public Viaje(String title, String description, String photoUrl, Float rating) {
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
        this.rating = rating;
    }

    public Viaje(){}
}

