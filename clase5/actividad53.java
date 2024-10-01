package clase5;

import java.util.*;

public class actividad53 {
    // Clase interna para representar una arista con un destino y un peso
    static class Arista {
        int destino, peso;

        Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Método para encontrar el Árbol de Recubrimiento Mínimo usando el algoritmo de Prim sin cola de prioridad
    public static void prim(List<List<Arista>> grafo, int numVertices) {
        // Arreglos de claves, padres y si un vértice está en el árbol MST
        int[] key = new int[numVertices]; // Pesos mínimos para incluir en el ARM
        int[] parent = new int[numVertices]; // Almacena el árbol de recubrimiento mínimo
        boolean[] inMST = new boolean[numVertices]; // Si el vértice ya está incluido en el ARM

        // Inicializar todos los valores de key como infinito y parent como -1
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0; // El primer vértice tiene peso 0 para ser seleccionado primero

        // Repetir hasta que todos los vértices estén en el árbol
        for (int i = 0; i < numVertices - 1; i++) {
            // Encuentra el vértice u que no está en inMST[] y tiene el valor key[] más bajo
            int u = -1;
            for (int j = 0; j < numVertices; j++) {
                if (!inMST[j] && (u == -1 || key[j] < key[u])) {
                    u = j;
                }
            }

            // Incluir u en el árbol (inMST[u] = true)
            inMST[u] = true;

            // Actualizar los valores
            for (Arista adyacente : grafo.get(u)) {
                int v = adyacente.destino;
                int peso = adyacente.peso;

                // Si v no está en el árbol y el peso de la arista (u, v) es menor que key[v]
                if (!inMST[v] && peso < key[v]) {
                    // Actualizamos key y parent
                    key[v] = peso;
                    parent[v] = u;
                }
            }
        }

        // Mostrar las conexiones del Árbol de Recubrimiento Mínimo y calcular el costo total
        int costoTotal = 0;
        System.out.println("Aristas en el Árbol de Recubrimiento Mínimo:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(parent[i] + " - " + i + " con costo " + key[i]);
            costoTotal += key[i];
        }
        System.out.println("Costo total del Árbol de Recubrimiento Mínimo: " + costoTotal);
    }

    public static void main(String[] args) {
        // Ejemplo de grafo con 5 vértices (estaciones eléctricas)
        int numVertices = 5;

        // Crear una lista de adyacencia para representar el grafo
        List<List<Arista>> grafo = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            grafo.add(new ArrayList<>());
        }

        // Añadir las aristas con los pesos correspondientes (distancias/costos)
        grafo.get(0).add(new Arista(1, 2)); // Estación 0 a Estación 1, costo 2
        grafo.get(0).add(new Arista(3, 6)); // Estación 0 a Estación 3, costo 6
        grafo.get(1).add(new Arista(0, 2)); // Estación 1 a Estación 0, costo 2
        grafo.get(1).add(new Arista(2, 3)); // Estación 1 a Estación 2, costo 3
        grafo.get(1).add(new Arista(3, 8)); // Estación 1 a Estación 3, costo 8
        grafo.get(1).add(new Arista(4, 5)); // Estación 1 a Estación 4, costo 5
        grafo.get(2).add(new Arista(1, 3)); // Estación 2 a Estación 1, costo 3
        grafo.get(2).add(new Arista(4, 7)); // Estación 2 a Estación 4, costo 7
        grafo.get(3).add(new Arista(0, 6)); // Estación 3 a Estación 0, costo 6
        grafo.get(3).add(new Arista(1, 8)); // Estación 3 a Estación 1, costo 8
        grafo.get(4).add(new Arista(1, 5)); // Estación 4 a Estación 1, costo 5
        grafo.get(4).add(new Arista(2, 7)); // Estación 4 a Estación 2, costo 7

        // Aplicar el algoritmo de Prim
        prim(grafo, numVertices);
    }
}