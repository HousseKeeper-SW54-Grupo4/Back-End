package backend.housekeeper.houseelegantservice.domain.model.aggregates;
import backend.housekeeper.shared.domain.model.entities.AuditableModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Entity
public class KeeperRequest extends AuditableModel {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "photoUrl")
    private String photoUrl;

    @Column(name = "rating")
    private Float rating;

    @CreatedDate
    @JsonIgnore
    private Date createdAt;

    @LastModifiedDate
    @JsonIgnore
    private Date updatedAt;

    public KeeperRequest() {

    }

    public KeeperRequest(String name, String message, String photoUrl, Float rating){
        this.name =  name;
        this.message = message;
        this.photoUrl = photoUrl;
        this.rating = rating;
    }


}
