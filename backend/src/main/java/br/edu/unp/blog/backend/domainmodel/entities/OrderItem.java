package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name="ORDER_ITEMS")
public class OrderItem {

    @EmbeddedId
    private @Getter @Setter OrderItemKey key;

    @Getter @Setter
    private String itemName;

    @Getter @Setter
    private int quantity;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false),
            @JoinColumn(name = "order_id", referencedColumnName = "order_id",insertable = false, updatable = false)
    })
    @Getter @Setter
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(key, orderItem.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
