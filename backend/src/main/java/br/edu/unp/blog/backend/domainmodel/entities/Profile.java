package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SYS003_PROFILES")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name="BIO", length = 255)
    private @Getter @Setter String bio;

    @Column(name="PICTURE", length = 255)
    private @Getter @Setter String pictureUri;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id);
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private @Getter @Setter User user;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
