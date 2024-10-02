package clase7;

import java.util.Scanner;

public class actividad73 {
    
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V]; 
        int pred[][] = new int[V][V]; 

        // Inicializar la matriz de distancias y predecesores
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j]; // Copiamos los valores iniciales
                if (graph[i][j] != INF && i != j) {
                    pred[i][j] = i; // Establecer el predecesor
                } else {
                    pred[i][j] = -1; // No hay predecesor
                }
            }
        }

        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si encontramos un camino más corto pasando por el nodo 'k', actualizamos
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j]; // Actualizamos el predecesor
                    }
                }
            }
        }