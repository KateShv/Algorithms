package lesson7;

import java.util.LinkedList;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    BreadthFirstPath(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }

    boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }



    //дз
    //поиск коротких путей от любой вершины к любой
    LinkedList<Integer> shortPath(Graph g, int from, int to){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(from);
        int[] temp = new int[g.getVertexCount()];
        boolean[] marked = new boolean[g.getVertexCount()];
        marked[from] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int i : g.getAdjList(vertex)) {
                if (!marked[i]) {
                    marked[i] = true;
                    temp[i] = vertex;
                    if(i == to){
                        return pathTo(from, to, temp, marked);
                    }
                    queue.addLast(i);
                }
            }
        }
        return new LinkedList<>();
    }

    private LinkedList<Integer> pathTo(int from, int to, int[] cameFrom, boolean[] marked){
        if (!marked[to]){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = to;
        while(vertex != from){
            stack.push(vertex);
            vertex = cameFrom[vertex];
        }
        return stack;
    }

    public int[] getEdgeTo() {
        return edgeTo.clone();
    }

    void showAdjacencyList(Graph g){
        showAllAdjLists(g, g.getAdjList());
    }

    private void showAllAdjLists(Graph g, LinkedList<Integer>[] linkedLists){
        for (int i = 0; i < linkedLists.length; i++) {
            System.out.println(i + ": " + g.getAdjList(i));
        }
    }

}
