package pl.ms.SafeDriving.model.forum;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ms.SafeDriving.model.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post_table")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "postId")
    private Long id;

    private String postText;

    private boolean reportViolence;

    private boolean isActive;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_Id")
    private Topic topic;

    @ManyToMany
    @JoinTable(name = "post_users", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "topicId"))
    private Set<User> users;
}
