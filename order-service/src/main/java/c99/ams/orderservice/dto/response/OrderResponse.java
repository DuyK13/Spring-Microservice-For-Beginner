package c99.ams.orderservice.dto.response;

import c99.ams.orderservice.entity.OrderDate;
import c99.ams.orderservice.entity.Product;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderResponse implements Serializable {
    private Long id;
    private String email;
    private List<OrderDate> orderDates;
    private List<Product> products;
    private String state;
    private String address;
    private String phoneNumber;
    private String fullName;

    public OrderResponse() {
    }

    public OrderResponse(Long id, String email, List<OrderDate> orderDates, List<Product> products, String state, String address, String phoneNumber, String fullName) {
        this.id = id;
        this.email = email;
        this.orderDates = orderDates;
        this.products = products;
        this.state = state;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public List<OrderDate> getOrderDates() {
        return orderDates;
    }

    public void setOrderDates(List<OrderDate> orderDates) {
        this.orderDates = orderDates;
        Collections.sort(this.orderDates, Comparator.comparing(OrderDate::getDateTime));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", orderDates=" + orderDates +
                ", products=" + products +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
