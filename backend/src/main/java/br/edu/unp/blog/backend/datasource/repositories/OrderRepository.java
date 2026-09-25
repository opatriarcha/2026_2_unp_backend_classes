package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Order;
import br.edu.unp.blog.backend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository  extends JpaRepository<Order, UUID> {
}
