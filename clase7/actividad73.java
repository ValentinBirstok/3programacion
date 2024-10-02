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
                // Imprimir la matriz de distancias finales
                printSolution(dist, V);
                // Verificar si existen ciclos negativos
                checkNegativeCycles(dist, V);
        
                // Solicitar el origen y el destino
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el nodo de origen (0 a " + (V-1) + "): ");
                int origen = scanner.nextInt();
                System.out.print("Ingrese el nodo de destino (0 a " + (V-1) + "): ");
                int destino = scanner.nextInt();
        
                // Imprimir el camino más corto
                printShortestPath(pred, origen, destino);
            }
        
            // Método para imprimir la solución
            void printSolution(int dist[][], int V) {
                System.out.println("Matriz de distancias más cortas entre cada par de centros de distribución:");
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][j] == INF)
                            System.out.print("INF ");
                        else
                            System.out.print(dist[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        
            // Método para verificar ciclos negativos
            void checkNegativeCycles(int dist[][], int V) {
                for (int i = 0; i < V; i++) {
                    if (dist[i][i] < 0) {
                        System.out.println("Existen ciclos negativos en el grafo.");
                        return; // Salimos si encontramos un ciclo negativo
                    }
                }
                System.out.println("No existen ciclos negativos en el grafo.");
            }