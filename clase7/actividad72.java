package clase7;

public class actividad72 {
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V]; // Crear matriz de distancias

        // Inicializar la matriz de distancias con los valores iniciales del grafo
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j]; // Copiamos los valores iniciales
            }
        }

        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si encontramos un camino más corto pasando por el nodo 'k', actualizamos
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
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
        