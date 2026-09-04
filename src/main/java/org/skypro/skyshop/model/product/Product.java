package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String name;
    private final UUID id;

    public Product(UUID id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
        this.id = id;
        this.name = name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    @JsonIgnore
    public String getType() {
        return "PRODUCT";
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}