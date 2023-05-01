package ru.netology.prod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    @Test
    void testSearchEmptyResult() {
        Product[] expected = new Product[0];
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product book1 = new Book(1, "Золотой Козлёнок", "Ильф и Петров");
        manager.addProduct(book1);
        Product book2 = new Book(2, "Козлёнок, который любил считать", "А. Азимов");
        manager.addProduct(book2);
        Product smart = new Smartphone(3, "Samsung 1");
        manager.addProduct(smart);

        Product[] actual = manager.searchBy("молоко");

        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchOneResult() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = new Product[1];

        Product book1 = new Book(1, "Золотой Козлёнок", "Ильф и Петров");
        manager.addProduct(book1);

        Product book2 = new Book(2, "Козлёнок, который любил считать", "А. Азимов");
        manager.addProduct(book2);

        Product smart = new Smartphone(3, "Samsung 1");
        manager.addProduct(smart);
        expected[0] = smart;

        Product[] actual = manager.searchBy("1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchManyResults() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = new Product[2];

        Product book1 = new Book(1, "Золотой Козлёнок", "Ильф и Петров");
        manager.addProduct(book1);
        expected[0] = book1;

        Product book2 = new Book(2, "Козлёнок, который любил считать", "А. Азимов");
        manager.addProduct(book2);
        expected[1] = book2;

        Product smart = new Smartphone(3, "Samsung 1");
        manager.addProduct(smart);

        Product[] actual = manager.searchBy("Козлёнок");

        assertArrayEquals(expected, actual);
    }
}
