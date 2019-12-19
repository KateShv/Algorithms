package lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    static Random rand = new Random();
    static float start, end;

    public static void main(String[] args) {
        //создаем массив размером 1000000 и сортируем выбором
        MyArrayList<Integer> list1 = new MyArrayList<>(1000000);

        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list1.add(rand.nextInt(100));
        }
        System.out.println(list1);
        end = (System.nanoTime() - start)*0.000000001f; //or /1000000000
        System.out.println("time to fill - " + end + " sec");

        start = System.nanoTime();
        list1.selectionSort();
        System.out.println(list1);
        end = (System.nanoTime() - start)*0.000000001f;
        System.out.println("the time of a selection sort - " + end + " sec");

        System.out.println();

        //новый массив и сортируем вставками
        MyArrayList<Integer> list2 = new MyArrayList<>(1000000);

        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list2.add(rand.nextInt(100));
        }
        System.out.println(list2);
        end = (System.nanoTime() - start)*0.000000001f; //or /1000000000
        System.out.println("time to fill - " + end + " sec");

        start = System.nanoTime();
        list2.insertionSort();
        System.out.println(list2);
        end = (System.nanoTime() - start)*0.000000001f;
        System.out.println("the time of a insertion sort - " + end + " sec");

        System.out.println();

        //еще массив и сортируем пузырьком
        MyArrayList<Integer> list3 = new MyArrayList<>(1000000);

        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list3.add(rand.nextInt(100));
        }
        System.out.println(list3);
        end = (System.nanoTime() - start)*0.000000001f; //or /1000000000
        System.out.println("time to fill - " + end + " sec");

        start = System.nanoTime();
        list3.bubbleSort();
        System.out.println(list3);
        end = (System.nanoTime() - start)*0.000000001f;
        System.out.println("the time of a bubble sort - " + end + " sec");

    }
}
