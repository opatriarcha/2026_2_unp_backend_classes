package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryCustomImpl  implements OrderRepositoryCustom{

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Order> findByTotalQuantityGreaterThanCriteria(Integer quantity){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Order.class);
        Root<Order> orderRoot = criteria.from(Order.class);
        List<Predicate> predicates = List.of();
        predicates.add(
                builder.greaterThan(orderRoot.get("totalQuantity"), quantity)
        );
        criteria.select(orderRoot).where(predicates);

        return this.entityManager.createQuery(criteria).getResultList();

    }
}
