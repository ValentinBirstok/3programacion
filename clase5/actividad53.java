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