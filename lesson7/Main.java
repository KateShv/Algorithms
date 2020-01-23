package lesson7;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*Graph graph = new Graph(10);

        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);
        graph.addEdge(1,3);

        System.out.println(graph.getAdjList(1));
        System.out.println(graph.getEdgeCount());

//        DepthFirstPath dfp = new DepthFirstPath(graph, 2);
//        System.out.println(dfp.hasPathTo(4));
//        System.out.println(dfp.hasPathTo(8));
//        System.out.println(dfp.pathTo(4));

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 2);
        System.out.println(bfp.hasPathTo(4));
        System.out.println(bfp.hasPathTo(8));
        System.out.println(bfp.pathTo(3));*/


        //дз
        Random random = new Random();
        Graph graph = new Graph(10);
        int i = 0;
        while (i < 10) {
            graph.addEdge(random.nextInt(10), random.nextInt(10));
            i++;
        }
        BreadthFirstPath bfp = new BreadthFirstPath(graph,0);
        bfp.showAdjacencyList(graph);
        int from = random.nextInt(10);
        int to = random.nextInt(10);
        LinkedList<Integer> path = bfp.shortPath(graph, from, to);
        System.out.println("Короткий путь из вершины " + from + " к вершине " + to + ": " + path);

    }
}
