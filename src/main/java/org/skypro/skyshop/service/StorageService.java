package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();

    public StorageService() {
        initData();
    }

    private void initData() {
        Product phone = new SimpleProduct(UUID.randomUUID(), "Телефон", 10000);
        products.put(phone.getId(), phone);
        for (int i = 0; i < 4; i++) {
            UUID id = UUID.randomUUID();
            Product product = new SimpleProduct(id, "Товар" + i, 1000);
            products.put(id, product);
        }
        SimpleProduct moreProduct = new SimpleProduct(UUID.randomUUID(), "Ещё товар", 500);
        products.put(moreProduct.getId(), moreProduct);

        SimpleProduct watch = new SimpleProduct(UUID.randomUUID(), "Часы", 5000);
        products.put(watch.getId(), watch);
        DiscountedProduct headphones = new DiscountedProduct(UUID.randomUUID(), "Наушники", 3000, 20);
        products.put(headphones.getId(), headphones);
        FixPriceProduct flashDrive = new FixPriceProduct(UUID.randomUUID(), "Флэшка");
        products.put(flashDrive.getId(), flashDrive);

        Article article1 = new Article(UUID.randomUUID(), "Как выбрать телефон", "Советы по выбору смартфона в 2026 году");
        Article article2 = new Article(UUID.randomUUID(), "Наушники и здоровье", "Влияние наушников на слух");
        Article article3 = new Article(UUID.randomUUID(), "Флэшки сегодня", "Какие флэшки покупать сейчас");
        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
        articles.put(article3.getId(), article3);
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> all = new ArrayList<>();
        all.addAll(products.values());
        all.addAll(articles.values());
        return all;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }
}
