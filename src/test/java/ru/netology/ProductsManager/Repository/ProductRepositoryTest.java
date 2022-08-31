package ru.netology.ProductsManager.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ProductsManager.Exception.AlreadyExistsException;
import ru.netology.ProductsManager.Exception.NotFoundException;
import ru.netology.ProductsManager.Product;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Product product1 = new Product(1, "продукт1", 1);
    Product product2 = new Product(2, "продукт2", 2);
    Product product3 = new Product(3, "продукт3", 3);
    Product product4 = new Product(4, "продукт4", 4);
    Product product5 = new Product(5, "продукт5", 5);

    @Test
    public void shouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.removeById(product1.getId());
        Product[] expected = {product2, product3, product4, product5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }

    @Test
    public void shouldNotAdd() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product4);
        });
    }
}
