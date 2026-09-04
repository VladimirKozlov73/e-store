package org.skypro.skyshop.model.basket;

import java.util.Collections;
import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final int total;

    public UserBasket(List<BasketItem> items) {
        this.items = List.copyOf(items);
        this.total = items.stream()
                .mapToInt(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public List<BasketItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getTotal() {
        return total;
    }
}