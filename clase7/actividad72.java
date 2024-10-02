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
        void checkNegativeCycles(int dist[][], int V) {
            for (int i = 0; i < V; i++) {
                if (dist[i][i] < 0) {
                    System.out.println("Existen ciclos negativos en el grafo.");
                    return; // Salimos si encontramos un ciclo negativo
                }
            }
            System.out.println("No existen ciclos negativos en el grafo.");
        }
    
        public static void main(String[] args) {
            actividad72 fw = new actividad72();
    
            // Definir el grafo con tiempos de viaje (en minutos)
            int graph[][] = {
                { 0, 10, 5, INF },   // Centro de distribución 1
                { INF, 0, INF, 1 },  // Centro de distribución 2
                { INF, 3, 0, 2 },    // Centro de distribución 3
                { INF, INF, INF, 0 } // Centro de distribución 4
            };
    
            int V = graph.length; // Número de vértices (centros de distribución)
            fw.floydWarshall(graph, V); // Ejecutar el algoritmo
        }
    }
        