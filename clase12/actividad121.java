package clase12;

import java.util.*;

public class actividad121 {

    // Clase para representar el grafo
    static class Grafo {
        private int numVertices; // Número de vértices
        private LinkedList<Integer>[] listaAdyacencia; // Lista de adyacencia

        // Constructor
        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            listaAdyacencia = new LinkedList[numVertices];
            for (int i = 0; i < numVertices; i++) {
                listaAdyacencia[i] = new LinkedList<>();
            }
        }

        // Método para agregar una arista en el grafo
        public void agregarArista(int origen, int destino) {
            listaAdyacencia[origen].add(destino);
        }

        // Método para realizar el recorrido DFS
        public void DFS(int nodoInicial) {
            boolean[] visitado = new boolean[numVertices]; // Array para nodos visitados
            DFSRecursivo(nodoInicial, visitado);
        }

        // Método recursivo para DFS
        private void DFSRecursivo(int nodo, boolean[] visitado) {
            // Marcar el nodo como visitado y procesarlo
            visitado[nodo] = true;
            System.out.print(nodo + " ");

            // Recorrer los vecinos del nodo
            for (int vecino : listaAdyacencia[nodo]) {
                if (!visitado[vecino]) {
                    DFSRecursivo(vecino, visitado);
                }
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Por ejemplo, un grafo con 5 nodos (0 a 4)
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 4);

        System.out.println("Recorrido DFS a partir del nodo 0:");
        grafo.DFS(0); // Llamada al método DFS a partir del nodo 0
    }
}
