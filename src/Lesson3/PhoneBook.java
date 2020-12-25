package Lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class PhoneBook {
    private Map<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String name, String phoneNumber){
        HashSet<String> list = phoneBook.get(name);
        if(list == null){
            list = new HashSet<>();
            phoneBook.put(name, list);
        }
        list.add(phoneNumber);
    }

    public HashSet<String> getNumber(String name){
        return phoneBook.get(name);
    }
}
