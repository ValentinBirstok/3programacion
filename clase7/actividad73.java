package clase7;

import java.util.Scanner;

public class actividad73 {
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    void floydWarshall(int graph[][], int V, int pred[][]) {
        int dist[][] = new int[V][V]; // Crear matriz de distancias

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

        // Aplicar el algoritmo de Floyd-Warshall
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

    // Método para imprimir el camino más corto
    void printShortestPath(int pred[][], int origen, int destino, int dist[][]) {
        if (pred[origen][destino] == -1) {
            System.out.println("No hay camino desde " + origen + " hasta " + destino);
            return;
        }

        System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        int actual = destino;
        StringBuilder path = new StringBuilder();

        // Reconstruir el camino desde el destino hasta el origen
        while (actual != origen) {
            path.insert(0, " -> " + actual);
            actual = pred[origen][actual];
            if (actual == -1) {
                System.out.println("No hay camino.");
                return;
            }
        }
        path.insert(0, origen); // Agregar el origen al inicio

        // Imprimir la distancia
        System.out.println(path);
        System.out.println("Distancia total: " + dist[origen][destino]);
    }

    public static void main(String[] args) {
        actividad73 fw = new actividad73();

        // Definir el grafo con tiempos de viaje (en minutos)
        int graph[][] = {
            { 0, 10, 5, INF },   // Centro de distribución 1
            { INF, 0, INF, 1 },  // Centro de distribución 2
            { INF, 3, 0, 2 },    // Centro de distribución 3
            { INF, INF, INF, 0 } // Centro de distribución 4

        };

        int V = graph.length; // Número de vértices (centros de distribución)

        // Crear la matriz de predecesores
        int pred[][] = new int[V][V];

        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall(graph, V, pred); 

        // Solicitar el origen y el destino
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nodo de origen (0 a " + (V - 1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino (0 a " + (V - 1) + "): ");
        int destino = scanner.nextInt();

        // Imprimir el camino más corto
        fw.printShortestPath(pred, origen, destino, graph);
    }
}
