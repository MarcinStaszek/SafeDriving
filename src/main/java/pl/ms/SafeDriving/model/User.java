package pl.ms.SafeDriving.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "userId")
    private Long id;

    @NotBlank(message = "Type youe first name")
    private String firstName;

    @NotBlank(message = "Type your last name")
    private String lastName;

    @Email
    @NotBlank(message = "Provide valid e-mail address, this will be your login")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Length(min = 5, message = "Your password must have at least 5 characters")
    private String password;

    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;

}
