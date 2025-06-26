package com.alkemy.ong.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // other fields...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // other getters and setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
