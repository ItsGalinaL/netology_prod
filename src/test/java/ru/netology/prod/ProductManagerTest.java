package ru.netology.prod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    @Test
    void testSearch() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product book1 = new Book(1, "Золотой Козлёнок", "Ильф и Петров");
        manager.addProduct(book1);
        Product book2 = new Book(2, "Козлёнок, который любил считать", "А. Азимов");
        manager.addProduct(book2);
        Product smart = new Smartphone(3, "Samsung 1");
        manager.addProduct(smart);

        assertEquals(2, manager.searchBy("Козлёнок").length);
    }
}
