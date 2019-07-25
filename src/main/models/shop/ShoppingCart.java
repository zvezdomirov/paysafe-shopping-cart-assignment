package main.models.shop;

import main.exceptions.NoSuchItemException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ShoppingCart {
    //value is the item's quantity
    private Map<ShopItem, Integer> cartContent;
    private BigDecimal totalPrice;

    public ShoppingCart() {
        this.cartContent = new HashMap<>();
        this.totalPrice = new BigDecimal(0);
    }

    public void addItem(ShopItem item,
                        Integer quantity) throws NoSuchItemException {
        if (item == null) {
            throw new NoSuchItemException(
                    "Item is not available in the list"
            );
        }
        int quantityAfterAdd = quantity
                + Optional
                .ofNullable(cartContent.get(item))
                .orElse(0);
        cartContent.put(item, quantityAfterAdd);
        totalPrice = item.getPrice()
                .multiply(BigDecimal.valueOf(quantityAfterAdd));
    }

    public boolean removeItem(ShopItem item,
                              Integer quantity) {
        int quantityAfterRemove = Optional
                .ofNullable(cartContent.get(item))
                .orElse(0) - quantity;
        if (quantityAfterRemove < 0) {
            return false;
        } else {
            cartContent.put(item, quantityAfterRemove);
            totalPrice = item.getPrice()
                    .multiply(BigDecimal.valueOf(quantityAfterRemove));
            return true;
        }
    }

    public String reviewContent() {
        StringBuilder result = new StringBuilder();
        cartContent
                .forEach((k, v) -> result.append(
                        String.format("%s x %d\n",
                                k.toString(), v)));
        result.append("Total Price: ")
                .append(totalPrice.toString());
        return result.toString();
    }

    public void clearCart() {
        cartContent.clear();
        totalPrice = new BigDecimal(0);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
