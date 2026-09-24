package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}


opatriarcha/2026_2_unp_backend_class

