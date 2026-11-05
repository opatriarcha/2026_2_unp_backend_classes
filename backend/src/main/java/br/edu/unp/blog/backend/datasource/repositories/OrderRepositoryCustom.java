package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    public List<Order> findByTotalQuantityGreaterThanCriteria(Integer quantity);
}
