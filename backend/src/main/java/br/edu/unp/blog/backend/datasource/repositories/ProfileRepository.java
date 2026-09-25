package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
}
