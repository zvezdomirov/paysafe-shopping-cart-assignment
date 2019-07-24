package main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<ShopItem, Integer> itemsQuantity;
    private BigDecimal totalPrice;

    public ShoppingCart() {
        this.itemsQuantity = new HashMap<>();
        this.totalPrice = new BigDecimal(0);
    }

    //returns the item's current quantity
    public void addItem(ShopItem item) {
        Integer quant = item.getQuantity()
                + this.itemsQuantity.get(item);
        itemsQuantity.put(item, quant);
        totalPrice = totalPrice.add(
                item.getPrice().multiply(
                        BigDecimal.valueOf(item.getQuantity())));
    }

    public boolean removeItem(ShopItem item) {
        if (!itemsQuantity.containsKey(item)) {
            return false;
        }
        Integer quant = itemsQuantity.get(item) - 1;
        if (quant == 0) {
            itemsQuantity.remove(item);
        } else {
            itemsQuantity.put(item, quant);
        }
        return true;
    }

    public String reviewContent() {
        StringBuilder result = new StringBuilder();
        for (ShopItem it: itemsQuantity.keySet()) {
            result.append(it.toString())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    public void clearCart() {
        itemsQuantity.clear();
        totalPrice = new BigDecimal(0);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
