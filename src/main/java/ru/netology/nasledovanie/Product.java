package ru.netology.nasledovanie;

public class Product {
    protected int id;
    protected String name;
    protected int price;
    protected Product[] products = new Product[0];

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    protected Product[] getProducts() {
        return products;
    }

    // public void setProducts(Product[] products) {
    //    this.products = products;
    // }

    public Product[] findAll() {
        return products;
    }

    protected void saveProducts(Product product) {
        Product[] prod = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            prod[i] = products[i];
        }
        prod[prod.length - 1] = product;
        products = prod;
    }

    public void removeById(int id) {
        Product[] prod = new Product[products.length - 1];
        int copyIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                prod[copyIndex] = product;
                copyIndex++;
            }
        }
        products = prod;
    }

    public int getId() {
        return id;
    }

    // public void setId(int id) {
    //    this.id = id;
    // }

    public String getName() {
        return name;
    }

    //public void setName(String name) {
    //   this.name = name;
    //}

    // public int getPrice() {
    //  return price;
    // }

    // public void setPrice(int price) {
    //  this.price = price;
    //}
}
