package pl.ms.SafeDriving.model.user;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ms.SafeDriving.model.forum.Club;
import pl.ms.SafeDriving.model.forum.Post;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users_table")
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

    private String address;

    private String occupation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany
    @JoinColumn(name = "reportedPost_user_id")
    private Set<Post> reportedPost;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}