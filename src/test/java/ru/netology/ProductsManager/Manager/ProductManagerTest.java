package ru.netology.ProductsManager.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ProductsManager.Book;
import ru.netology.ProductsManager.Product;
import ru.netology.ProductsManager.Repository.ProductRepository;
import ru.netology.ProductsManager.Smartphone;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "product 1", 100, "author1");
    Book book2 = new Book(2, "product 2", 200, "author2");
    Book book3 = new Book(3, "product 3", 200, "author1");
    Book book4 = new Book(4, "product 4", 200, "author3");
    Book book5 = new Book(5, "book", 200, "author1");

    @Test
    public void shouldSearch() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        Product[] expected = {book1, book2, book3,book4};
        Product[] actual = manager.searchBy("product");
        Assertions.assertArrayEquals(expected, actual);
    }

    Smartphone smartphone1 = new Smartphone(1, "phone1", 100, "manufacture1");
    Smartphone smartphone2 = new Smartphone(1, "phone2", 100, "manufacture1");
    Smartphone smartphone3 = new Smartphone(1, "phone3", 100, "manufacture1");
    Smartphone smartphone4 = new Smartphone(1, "smartphone4", 100, "manufacture1");
    @Test
    public void shouldNotSearch() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        Product[] expected = { };
        Product[] actual = manager.searchBy("валенок");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchOne() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        Product[] expected = {smartphone4};
        Product[] actual = manager.searchBy("smartphone");
        Assertions.assertArrayEquals(expected, actual);
    }
}
