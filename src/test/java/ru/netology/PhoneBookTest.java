package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


class PhoneBookTest {
    PhoneBook book = new PhoneBook();

    @ParameterizedTest
    @CsvSource(value = {
            "Anton, +7(999)923-43-45",
            "Dima, +7(959)963-47-95",
            "Lera, +7(949)783-44-41",
            "Tony, +7(959)953-83-42"})

    public void testAdd(String name, String phone) {


        int sizePhoneBook = book.add(name, phone);
        Assertions.assertNotEquals(sizePhoneBook, 0);
    }

    @Test
    public void testAddTwo() {
        String name = "Anton";
        String phone = "+7(999)923-43-45";
        int sizePhoneBook = book.add(name, phone);
        Assertions.assertEquals(sizePhoneBook, 1);
        book.add(name, phone);
        Assertions.assertEquals(sizePhoneBook, 1);
        String nameTwo = "Lera";
        String phoneTwo = "+7(949)783-44-41";
        int sizePhoneBook2 = book.add(nameTwo, phoneTwo);
        Assertions.assertEquals(sizePhoneBook2, 2);
    }


    @ParameterizedTest
    @ValueSource(strings = {"+7(949)783-44-41", "+7(999)923-43-45"})
    void testFindByNumber(String phone) {
        book.add("Anton", "+7(999)923-43-45");
        book.add("Lera", "+7(949)783-44-41");

        String name = book.findByNumber(phone);
        Assertions.assertNotEquals(name, null);
    }

    @Test
    void testFindByNumberTwo() {
        book.add("Anton", "+7(999)923-43-45");
        String name = book.findByNumber("+7(999)923-43-45");
        Assertions.assertEquals(name, "Anton");
    }

    @Test
    void testFindByName() {
        book.add("Dima", "+7(696)955-20-20");
        String phone = book.findByName("Dima");
        Assertions.assertEquals(phone, "+7(696)955-20-20");
    }


    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPrintAllNames() {
        book.add("Dima", "+7(696)955-20-20");
        book.add("Anton", "+7(999)923-43-45");
        book.printAllNames();

        Assertions.assertEquals("Anton" + "\n" + "Dima", outputStream.toString()
                .trim());
    }

}