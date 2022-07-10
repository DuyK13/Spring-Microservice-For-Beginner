package c99.ams.orderservice.entity;

import c99.ams.orderservice.utils.enums.State;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders", indexes =
        {@Index(name = "IDX_Search", columnList = "id")})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "email")
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<OrderDate> orderDates;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Product> products;

    private UserInformation userInformation;

    public Order() {

    }

    public Order(String email) {
        this.email = email;
        this.state = State.CART;
    }

    public Order(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Order(Long id, String email, Set<OrderDate> orderDates, State state, Set<Product> products,
                 UserInformation userInformation) {
        this.id = id;
        this.email = email;
        this.orderDates = orderDates;
        this.state = state;
        this.products = products;
        this.userInformation = userInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderDate> getOrderDates() {
        return orderDates;
    }

    public void setOrderDates(Set<OrderDate> orderDates) {
        this.orderDates = orderDates;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(email, order.email) && Objects.equals(orderDates, order.orderDates) && state == order.state && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, orderDates, state, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", orderDates=" + orderDates +
                ", state=" + state +
                ", products=" + products +
                ", userInformation=" + userInformation +
                '}';
    }
}
