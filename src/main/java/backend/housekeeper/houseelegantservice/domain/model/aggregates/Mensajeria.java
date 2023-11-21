package backend.housekeeper.houseelegantservice.domain.model.aggregates;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Entity
public class Mensajeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;

    @Column(name = "description")
    private String description;

    @Column(name = "photo_face")
    private String photoFace;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Mensajeria(Long id, String nombre, String description, String photoFace) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.photoFace = photoFace;
    }

    public Mensajeria() {

    }
}
