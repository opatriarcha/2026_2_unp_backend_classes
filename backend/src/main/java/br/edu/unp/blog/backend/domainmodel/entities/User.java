package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="SYS001_USERS")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private @Getter @Setter UUID id;

    @Column(name = "NAME", nullable = false, length = 100)
    private @Getter @Setter String name;

    @Column(name="EMAIL", nullable = false, length = 30)
    private @Getter @Setter String email;

    @Column(name="PASSWORD", nullable = false, length = 50)
    private @Getter @Setter String password;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @OneToOne(mappedBy = "user")
    private @Getter @Setter Profile profile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SYS004_USERS_ROLES",
            joinColumns =
            @JoinColumn(name = "user_id"),
            inverseJoinColumns =
            @JoinColumn(name = "role_id")
    )
    private @Getter @Setter Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private @Getter @Setter Set<Post> posts;

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
