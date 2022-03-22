package ru.netology.storage;

import ru.netology.domain.Product;
import ru.netology.exceptions.*;

public class Repository {
    private Product[] items = new Product[0];

    public Repository() {
    }

    public void addItem(Product newItem) {

        int newItemId = newItem.getId();
        if (findById(newItemId) != null)
            throw new AlreadyExistsException("Product with id " + String.valueOf(newItemId) + " already exists");

        Product[] modifiedStorage = new Product[items.length + 1];
        System.arraycopy(items, 0, modifiedStorage, 0, items.length);
        modifiedStorage[items.length] = newItem;
        items = modifiedStorage;
    }

    public Product[] findAll() {
        Product[] temp = new Product[items.length];
        System.arraycopy(items, 0, temp, 0, items.length);
        return temp;
    }

    public void removeItemById(int id) {

        if (findById(id) == null)
            throw new NotFoundException("Product with id " + String.valueOf(id) + " was not found");

        //now we know for sure, that we will modify items array:
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    private Product findById(int idToFind) {
        for (Product currProduct : items) {
            if (currProduct.getId() == idToFind)
                return currProduct;
        }
        return null;
    }
}
