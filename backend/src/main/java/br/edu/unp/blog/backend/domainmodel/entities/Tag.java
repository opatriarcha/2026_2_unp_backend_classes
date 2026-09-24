package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="SYS005_TAGS")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter
    @Setter UUID id;

    @Column(name="NAME", length = 10)
    private @Getter @Setter String name;

    @ManyToMany( mappedBy = "tags", fetch = FetchType.LAZY)
    private @Getter @Setter Set<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
