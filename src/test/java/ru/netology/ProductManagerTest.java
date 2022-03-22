package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;
import ru.netology.manager.ProductManager;
import ru.netology.storage.Repository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private Repository repository = new Repository();

    private Book book01 = new Book(10, "Uncle Tom's Cabin", 19, "Harriet Beecher Stowe", 235, 1967);
    private Book book02 = new Book(20, "Alice's Adventures in Wonderland", 25, "Lewis Carroll", 112, 1995);
    private Book book03 = new Book(30, "Do Androids Dream of Electric Sheep?", 39, "Philip K. Dick", 56, 1982);
    private Book book04 = new Book(50, "The Hitchhiker's Guide to the Galaxy", 42,"Douglas Adams", 117, 1999);

    private TShirt ts01 = new TShirt(100, "Ferrum Chloride Riders", 19, "Dirty Green", "M");
    private TShirt ts02 = new TShirt(200, "TNT Bastards", 25, "Neon Contemporary", "L");
    private TShirt ts03 = new TShirt(300, "Чебурашка Inc.", 15, "Lavender Brown", "S");

    @Test
    public void shouldAddUniqueIds(){
        ProductManager pm = new ProductManager(repository);
        pm.add(book01);
        pm.add(book02);
        pm.add(book03);
        pm.add(book04);
        pm.add(ts01);
        pm.add(ts02);
        pm.add(ts03);

        Product[] expected = new Product[]{book01, book02, book03, book04, ts01, ts02, ts03};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldTryAddNonUniqueIds(){
        ProductManager pm = new ProductManager(repository);
        pm.add(book01);
        pm.add(book02);
        pm.add(book03);
        pm.add(book04);
        pm.add(ts01);
        pm.add(ts02);
        pm.add(ts03);

        //same id as book03
        TShirt collisionItem = new TShirt(30, "I'm up to no good", 6, "Chrome Contrast", "XXXL");
        assertThrows(AlreadyExistsException.class, ()->pm.add(collisionItem));
    }

    @Test
    public void shouldRemoveExisting(){
        ProductManager pm = new ProductManager(repository);
        pm.add(book01);
        pm.add(book02);
        pm.add(book03);
        pm.add(book04);
        pm.add(ts01);
        pm.add(ts02);
        pm.add(ts03);

        pm.removeById(50); //book04
        Product[] expected = new Product[]{book01, book02, book03, ts01, ts02, ts03};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldTryRemoveNonExisting(){
        ProductManager pm = new ProductManager(repository);
        pm.add(book01);
        pm.add(book02);
        pm.add(book03);
        pm.add(book04);
        pm.add(ts01);
        pm.add(ts02);
        pm.add(ts03);

        assertThrows(NotFoundException.class, ()->pm.removeById(80)); //takogo id tochno net!
    }
}
