package Lesson3;

import java.util.HashMap;
import java.util.Map;

public class MainCollections {
    public static void main(String[] args) {

        String[] words = {"яблоко", "груша", "слива", "яблоко", "вишня", "морковка", "тыква", "абрикос", "вишня", "груша"};
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i< words.length; i++){
            String word = words[i];
            Integer val = map.getOrDefault(word, 0);
            map.put (word, val+1);
        }
        System.out.println(map);

        PhoneBook book = new PhoneBook();
        book.add ("Petrov", "phone:123456");
        book.add ("Petrov", "phone:654321");
        book.add("Ivanov", "phone:987654");

        System.out.println("Номера телефонов абонента Petrov: "+book.getNumber("Petrov"));
        System.out.println("Номера телефонов абонента Ivanov: "+book.getNumber("Ivanov"));
    }

}
