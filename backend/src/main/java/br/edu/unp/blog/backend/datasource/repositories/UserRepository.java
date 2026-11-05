package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT DISTINCT u FROM User u JOIN u.roles r WHERE r.name = :roleName")
    public List<User> findByRole(String roleName);

    @Query(value = "SELECT DISTINCT(u.id) FROM SYS001_USERS u, SYS002_ROLES r WHERE r.user_id = u.id AND r.NAME = :roleName", nativeQuery = true)
    public List<User> findByRola(String roleName);
}



