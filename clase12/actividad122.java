package clase12;

import java.util.*;

public class actividad122 {

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

        // Método para realizar el recorrido BFS
        public void BFS(int nodoInicial) {
            Queue<Integer> cola = new LinkedList<>(); // Cola para BFS
            Set<Integer> visitado = new HashSet<>();  // Conjunto para nodos visitados

            // Marcar nodo inicial como visitado y agregarlo a la cola
            cola.offer(nodoInicial);
            visitado.add(nodoInicial);

            // Mientras la cola no esté vacía
            while (!cola.isEmpty()) {
                // Dequeue: sacar el nodo de la cola
                int nodo = cola.poll();
                procesar(nodo); // Aquí se realiza alguna operación con el nodo (ej. imprimirlo)

                // Explorar vecinos no visitados
                for (int vecino : listaAdyacencia[nodo]) {
                    if (!visitado.contains(vecino)) {
                        visitado.add(vecino);
                        cola.offer(vecino);
                    }
                }
            }
        }
        private void procesar(int nodo) {
            System.out.print(nodo + " ");
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

        System.out.println("Recorrido BFS a partir del nodo 0:");
        grafo.BFS(0); // Llamada al método BFS a partir del nodo 0
    }
}