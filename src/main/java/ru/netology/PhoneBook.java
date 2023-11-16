package ru.netology;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    public String findByNumber(String number) {
        BiMap<String, String> phoneBookName = HashBiMap.create(phoneBook);
        return phoneBookName.inverse().get(number);
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }

    public void printAllNames() {
        Map<String, String> treeMap = new TreeMap<>(phoneBook);
        for (String name : treeMap.keySet()) {
            System.out.print(name + "\n");
        }
    }
}