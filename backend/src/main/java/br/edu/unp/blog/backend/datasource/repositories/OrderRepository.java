package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Order;
import br.edu.unp.blog.backend.domainmodel.entities.OrderKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface OrderRepository  extends
        JpaRepository<Order, OrderKey>,
        QuerydslPredicateExecutor<Order>,
        OrderRepositoryCustom{
}
