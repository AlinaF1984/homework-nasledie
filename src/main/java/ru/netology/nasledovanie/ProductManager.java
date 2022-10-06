package ru.netology.nasledovanie;

public class ProductManager {

    protected Product repository;

    public ProductManager(Product repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.saveProducts(product);
    }

    public Product[] getProducts() {
        Product[] all = repository.getProducts();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }


}


