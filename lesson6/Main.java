package lesson6;

import java.util.Random;

public class Main {

    static MyTreeMap[] trees;

    @Override
    public String toString(){
        if (trees == null || trees.length == 0) {
            return "map is empty!";
        }
        StringBuilder sb = new StringBuilder();
        for (MyTreeMap tree: trees) {
            sb.append(toString(tree));
        }
        return sb.toString();
    }

    static String toString(MyTreeMap tree){
        if (tree == null) {
            return "";
        }
        return tree.toString() + "\nbalance: " + tree.isBalanced() + "\n";
    }

    public static void main(String[] args) {

        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(5,"five");
        map.put(1,"one");
        map.put(3,"tree");
        map.put(2,"two");
        map.put(4,"four");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.delete(2);
        System.out.println(map.contains(2));
        System.out.println(map.size());
        System.out.println(map);

        System.out.println();

        //дз
        int maxTrees = 20;
        int maxHeight = 6;
        trees = new MyTreeMap[maxTrees];
        int countTrue = 0;
        int countFalse = 0;

        for (int i = 0; i < trees.length; i++) {
            MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
            trees[i] = treeMap;
            Random random = new Random();
            while(treeMap.height() <= maxHeight) {
                int key = random.nextInt(200) - 100;
                int value = random.nextInt(200) - 100;
                treeMap.put(key, value);
            }
            if (trees[i].isBalanced()) {
                countTrue++;
            } else {
                countFalse++;
            }
            //если понадобится распечатать эти деревья
            //со статусом сбалансировано или нет
            //по желанию можно использовать или закоментить
            //если не использовать - оверрайд тустринга и доп метод в мейне выше не нужны
            System.out.println(toString(trees[i]));
        }

        System.out.println("Сбалансированных деревьев: " + countTrue * 100 / maxTrees + "%");
        System.out.println("Несбалансированных деревьев: " + countFalse * 100 / maxTrees + "%");

    }
}
