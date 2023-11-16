package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public Map<String, String> phoneBook = new HashMap<>();

    public int add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.size();
        } else {
            phoneBook.put(name, phone);
        }

        return phoneBook.size();
    }
}
