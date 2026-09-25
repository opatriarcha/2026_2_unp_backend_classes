package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Tag;
import br.edu.unp.blog.backend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository  extends JpaRepository<Tag, UUID> {
}
