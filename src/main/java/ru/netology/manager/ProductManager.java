package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.storage.Repository;

public class ProductManager {
    private Repository repository;

    public ProductManager(Repository r) {
        repository = r;
    }

    public void add(Product newItem) {
        repository.addItem(newItem);
    }

    public void removeById(int productId) {
        repository.removeItemById(productId);
    }
}
