package pl.ms.SafeDriving.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "roleId")
    private Long id;

    private String role;
}
