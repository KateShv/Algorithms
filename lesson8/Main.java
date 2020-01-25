package lesson8;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*ChainingHashMap<Integer, String> map = new ChainingHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        System.out.println(map.contains(2));
        System.out.println(map.get(4));
        map.put(4,"four4");
        System.out.println(map.get(4));
        Random random = new Random();
        for (int i = 0; i < 35; i++) {
            map.put(random.nextInt(1000), "");
        }
        System.out.println(map);


        LinearProbingHashMap<Integer, String> map1 = new LinearProbingHashMap<>();
        map1.put(1, "one");
        map1.put(2, "two");
        map1.put(3, "three");
        map1.put(4, "four");
        map1.put(5, "five");
        System.out.println(map1.contains(2));
        System.out.println(map1.get(4));
        map1.put(4, "four4");
        System.out.println(map1.get(4));
        Random random1 = new Random();
        for (int i = 0; i < 80; i++) {
            map1.put(random1.nextInt(1000), "");
        }
        System.out.println(map);


        LinkedList ls = new LinkedList();
        ls.removeIf(x -> x.equals("java"));*/


        //дз 1часть
        ChainingHashMap<Integer, String> map2 = new ChainingHashMap<>();
        map2.put(1, "one");
        map2.put(2, "hey");
        map2.put(3, "Harry");
        map2.put(4, "welcome");
        map2.put(5, "Hogwarts");
        map2.put(189, "hey");
        Random random3 = new Random();
        for (int i = 0; i < 10; i++) {
            map2.put(random3.nextInt(1000), "test");
        }
        map2.put(1387, "hey");
        System.out.println(map2);
        System.out.println(map2.get(1387));
        System.out.println(map2.removeNode(2));
        System.out.println(map2);


        //дз 2 часть
        LinearProbingHashMap<Integer, String> map3 = new LinearProbingHashMap<>(20);
        map3.put(0, "TEST");
        Random random4 = new Random();
        for (int i = 0; i < 10; i++) {
            map3.put(random4.nextInt(1000), "test");
        }
        map3.put(854, "Kate");
        System.out.println(map3);
        map3.put(14, "hey");
        System.out.println(map3.delete(14));
        System.out.println(map3);
        System.out.println(map3.get(854));
        System.out.println(map3.delete(0));
        System.out.println(map3);


    }
}
