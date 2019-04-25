package pl.ms.SafeDriving.model.forum;

import lombok.Data;
import pl.ms.SafeDriving.model.user.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Entity
@Table(name = "club_table")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "clubId")
    private Long id;

    private String name;

}
