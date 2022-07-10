package c99.ams.orderservice.dto;

import c99.ams.orderservice.entity.Product;

import java.io.Serializable;
import java.util.List;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/8/2021 3:27 PM
 */
public class ProductDTO implements Serializable {
    private String id;
    private String name;
    private int quantity;
    private Long price;
    private String color;
    private String image;

    public ProductDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
