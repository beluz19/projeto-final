package model;

/**
 * Entity from database
 */

public class Product {
    // Primary key
    private Long id;
    private String name;
    // Prevent float number, multiply by 100
    private Integer value;
    private Integer stock;

    public Product() {

    }

    public Product(Long id, String name, Integer value, Integer stock) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", value=" + value + ", stock=" + stock + "]";
    }

}
