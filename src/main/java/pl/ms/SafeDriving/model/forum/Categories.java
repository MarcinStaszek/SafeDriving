package pl.ms.SafeDriving.model.forum;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "categories_table")
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "categoriesId")
    private Long id;

    private String name;

}
