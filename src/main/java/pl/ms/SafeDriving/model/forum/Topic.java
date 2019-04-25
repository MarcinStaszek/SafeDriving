package pl.ms.SafeDriving.model.forum;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ms.SafeDriving.model.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "topic_table")
@Data
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "topicId")
    private Long Id;

    private int numberOfViews;

    private int numberOfPosts;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_Id")
    private Post post;

    @ManyToMany
    @JoinTable(name = "topic_users", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "topicId"))
    private Set<User> users;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Categories categories;

}
