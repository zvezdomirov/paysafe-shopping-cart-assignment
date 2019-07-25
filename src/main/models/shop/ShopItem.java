package main.models.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ShopItem implements Cloneable{
    //id is auto generated
    private static Integer currentGeneratedId = 0;
    private Integer id;
    private String name;
    private BigDecimal price;

    public ShopItem(String name, BigDecimal price) {
        this.id = currentGeneratedId;
        currentGeneratedId++;
        this.setName(name);
        this.setPrice(price);
    }

    public Integer getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.CEILING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return name.equals(shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    protected ShopItem clone() {
        return new ShopItem(this.name, this.price);
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
