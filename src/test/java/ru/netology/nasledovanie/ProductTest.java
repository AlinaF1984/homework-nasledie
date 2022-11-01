package ru.netology.nasledovanie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {


    @Test
    public void testAdd() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Product product1 = new Product(1, "AA", 10);

        manager.add(product1);


        Product[] expected = manager.findAll();
        Product[] actual = {product1};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSearchWhenProductsFinded() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Product product1 = new Product(1, "AA", 10);
        Product product2 = new Product(2, "aa", 100);
        Product product3 = new Product(3, "ab", 200);
        Product product4 = new Product(4, "ab", 300);


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] expected = manager.searchBy("ab");
        Product[] actual = {product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneProductsFinded() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Product product1 = new Product(1, "AA", 10);
        Product product2 = new Product(2, "aa", 100);
        Product product3 = new Product(3, "ab", 200);
        Product product4 = new Product(4, "ab", 300);


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = manager.searchBy("AA");
        Product[] actual = {product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoProductsFinded() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Product product1 = new Product(1, "AA", 10);
        Product product2 = new Product(2, "aa", 100);
        Product product3 = new Product(3, "ab", 200);
        Product product4 = new Product(4, "ab", 300);


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = manager.searchBy("OO");
        Product[] actual = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeIdProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Product product1 = new Product(1, "AA", 10);
        Product product2 = new Product(2, "aa", 100);
        Product product3 = new Product(3, "ab", 200);
        Product product4 = new Product(4, "ab", 300);


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        repo.removeById(product2.getId());

        Product[] expected = repo.getProducts();
        Product[] actual = {product1, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFinAll() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Product product1 = new Product(1, "AA", 10);
        Product product2 = new Product(2, "aa", 100);
        Product product3 = new Product(3, "ab", 200);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}