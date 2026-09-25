package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Role;
import br.edu.unp.blog.backend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
