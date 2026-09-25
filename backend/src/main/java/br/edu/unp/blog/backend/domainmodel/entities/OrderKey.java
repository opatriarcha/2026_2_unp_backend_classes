package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderKey {

    @Getter @Setter @Column(name = "USER_ID")
    private UUID userId;

    @Getter @Setter
    @Column(name = "ORDER_ID")
    private UUID orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey orderId1 = (OrderKey) o;
        return Objects.equals(userId, orderId1.userId) && Objects.equals(orderId, orderId1.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, orderId);
    }
}
