package ru.netology.prod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void testEmptyRepository() {
        ProductRepository repository = new ProductRepository();

        assertEquals(0, repository.findAll().length);
    }

    @Test
    void testRepositoryFindAll() {
        ProductRepository repository = new ProductRepository();
        Product book = new Book(1, "Золотой телёнок", "Ильф и Петров");
        repository.addProduct(book);

        Product book2 = new Book(2, "Я робот", "А. Азимов");
        repository.addProduct(book2);

        assertEquals(2, repository.findAll().length);
    }

    @Test
    void testRepositoryRemove() {
        ProductRepository repository = new ProductRepository();
        Product book1 = new Book(1, "Золотой телёнок", "Ильф и Петров");
        repository.addProduct(book1);
        Product book2 = new Book(2, "Я робот", "А. Азимов");
        repository.addProduct(book2);
        Product smart = new Smartphone(3, "Samsung 1");
        repository.addProduct(smart);

        repository.removeProduct(2);

        assertEquals(2, repository.findAll().length);
    }
}