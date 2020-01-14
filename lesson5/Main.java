package lesson5;

public class Main {

    public static void main(String[] args) {

        System.out.println(Exponentiation.exp(2, 12));
        System.out.println(Exponentiation.expOptimized(2, 12));

        int knapsackCapacity = 50;
        Items[] items = {
                new Items(20, 35),
                new Items(15, 21),
                new Items(8, 62),
                new Items(10, 14),
                new Items(25, 150)
        };
        Knapsack knapsack = new Knapsack(items);
        System.out.println(knapsack.bestRes(items.length - 1, knapsackCapacity));

    }

}
