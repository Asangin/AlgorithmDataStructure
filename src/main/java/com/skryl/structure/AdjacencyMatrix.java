package com.skryl.structure;

public class AdjacencyMatrix {
	static class Graph {
        int V;
        int[][] adjMatrix;

        Graph(int V) {
            this.V = V;
            adjMatrix = new int[V][V];
        }
        void addEdge(int src, int dest) {
            adjMatrix[src-1][dest-1] = 1;
        }
        void removeEdge(int src, int dest) {
            adjMatrix[src-1][dest-1] = 0;
        }
        void print() {
            for(int j = 0; j < V; j++) {
                for(int k = 0; k < V; k++)
                    System.out.print(adjMatrix[j][k]+" ");
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
    
        Graph G = new Graph(5);

        G.addEdge(1, 2);
        G.addEdge(1, 5);
        G.addEdge(2, 3);
        G.addEdge(2, 4);
        G.addEdge(2, 5);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
    
        G.print();
  }
}
