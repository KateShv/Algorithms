package lesson7;

import java.util.LinkedList;

public class Graph {
    private int vertexCount;
    private int edgeCount = 0;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException("Количество вершин в графе не может быть < 0");
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    int getVertexCount() {
        return vertexCount;
    }

    int getEdgeCount() {
        return edgeCount;
    }

    LinkedList<Integer> getAdjList(int vertex) {
        return (LinkedList<Integer>) adjList[vertex].clone();
    }


    //дз
    //простой клон
    LinkedList<Integer>[] getAdjList() {
        return adjList.clone();
    }


    void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 ||
                v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        edgeCount++;
        if (v1 == v2) {
            adjList[v1].add(v1);
            return;
        }
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}
