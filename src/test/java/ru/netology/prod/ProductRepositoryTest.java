package ru.netology.prod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void testEmptyRepository() {
        Product[] expected = new Product[0];

        ProductRepository repository = new ProductRepository();

        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void testRepositoryFindAll() {
        Product[] expected = new Product[2];
        ProductRepository repository = new ProductRepository();

        Product book = new Book(1, "Золотой телёнок", "Ильф и Петров");
        repository.addProduct(book);
        expected[0] = book;

        Product book2 = new Book(2, "Я робот", "А. Азимов");
        repository.addProduct(book2);
        expected[1] = book2;

        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void testRepositoryRemove() {
        Product[] expected = new Product[2];

        ProductRepository repository = new ProductRepository();

        Product book1 = new Book(1, "Золотой телёнок", "Ильф и Петров");
        repository.addProduct(book1);
        expected[0] = book1;

        Product book2 = new Book(2, "Я робот", "А. Азимов");
        repository.addProduct(book2);

        Product smart = new Smartphone(3, "Samsung 1");
        repository.addProduct(smart);
        expected[1] = smart;

        repository.removeProduct(2);
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}