package ru.netology.prod;

public class ProductRepository {

    private Product[] products;

    public ProductRepository() {
        products = new Product[0];
    }

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeProduct(int id) {
        if (products.length != 0) {
            int i = 0;
            Product[] tmp = new Product[products.length - 1];
            for (Product product: products) {
                if (product.getId() != id) {
                    tmp[i] = product;
                    i++;
                }
            }
            products = tmp;
        }
    }
}
