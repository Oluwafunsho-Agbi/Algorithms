package breadth_first_search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<VertexData> vertexData;
    private boolean visited[];
    private int time = 0;
    // adjacency list is mainted as an array of linked list
    // vertices 0 to n-1  if there n vertices
    // we make an array of n linkedlist
    private LinkedList<Integer> adjacencyList[];

    // initializing the adjacencylist
    Graph(int numOfVertices) {
        vertexData = new ArrayList<>();
        adjacencyList = new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; ++i) {
            adjacencyList[i] = new LinkedList();
            vertexData.add(new VertexData());
        }

        visited = new boolean[numOfVertices];
    }

// adds the edge between verte1 and vertex2
    // since this is an undirected graph we update the
    // adjacency list for both the vertices
    void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);

    }

    public static void main(String args[]) {
        // creates a graph with 8 vertices numbering from 0 to 7
        Graph graph = new Graph(8);
        // add random edge between vertices
        graph.addEdge(0, 1);graph.addEdge(1, 2);graph.addEdge(2, 3);graph.addEdge(3, 4);
        graph.addEdge(4, 5);graph.addEdge(3, 5);graph.addEdge(4, 6);graph.addEdge(5, 6);
        graph.addEdge(6, 7);graph.addEdge(5, 7);

        System.out.println("Result of running DFS on vertex 2");
        graph.dfs(2);
    }


    private void dfs(int v) {
        runDFS(v, visited);
    }

    void runDFS(int vertex, boolean visited[]) {
        time++;
        vertexData.get(vertex).setDiscoveryTime(time);
        visited[vertex] = true;
        System.out.println("Visited vertex : "+vertex);
        Iterator<Integer> iterator = adjacencyList[vertex].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                runDFS(n, visited);
                vertexData.get(n).setParentNode(vertex);
            }
        }
        time++;
        vertexData.get(vertex).setFinishTime(time);
    }
/*
VertexData saves holds the parent-child relation
that gets build during the DFS traversal.
It also contains the time of discovery and finish time
 */
    private class VertexData {
        private int discoveryTime;
        private int finishTime;
        private int parentNode;

        public VertexData() {
            discoveryTime = -1;
            finishTime = -1;
            parentNode = -1;
        }

        public int getParentNode() {
            return parentNode;
        }

        public void setParentNode(int parentNode) {
            this.parentNode = parentNode;
        }

        public void setDiscoveryTime(int discoveryTime) {
            this.discoveryTime = discoveryTime;
        }

        public void setFinishTime(int finishTime) {
            this.finishTime = finishTime;
        }
    }

}