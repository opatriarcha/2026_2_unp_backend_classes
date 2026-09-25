package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="SYS006_POSTS")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private @Getter @Setter UUID id;

    @Column(name = "TITLE", length = 100)
    private @Getter @Setter String title;

    @Column( name = "CONTENT", length = 255)
    private @Getter @Setter String content;

    @ManyToMany
    @JoinTable(name = "SYS007_POSTS_TAGS",
            joinColumns =
                @JoinColumn(name = "POST_ID"),
                inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private @Getter @Setter Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private @Getter @Setter User user;



}
