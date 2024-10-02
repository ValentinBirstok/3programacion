package clase7;

public class actividad71 {
    
    final static int INF = 99999; // Usamos un valor grande para representar el infinito
    
    
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V]; // Crear matriz de distancias
    
        // Inicializar la matriz de distancias con los valores iniciales del grafo
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j]; // Copiamos los valores iniciales
            }
        }
    
        
        for (int k = 0; k < V; k++) {   // Ciclo sobre el nodo intermedio 'k'
            for (int i = 0; i < V; i++) {   // Ciclo sobre el nodo origen 'i'
                for (int j = 0; j < V; j++) {   // Ciclo sobre el nodo destino 'j'
                // Actualización de la distancia más corta si encontramos un camino mejor
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }
}
     // Imprimir la matriz de distancias finales
     printSolution(dist, V);
    }

    // Método para imprimir la solución
    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
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
    public static void main(String[] args) {
        actividad71 fw = new actividad71();

        // Definir el grafo según las aristas que mencionas
        int graph[][] = {
            { 0, 2, INF, 5 },   // Nodo 1: 1 → 2 (peso 2), 1 → 4 (peso 5)
            { INF, 0, INF, 4 }, // Nodo 2: 2 → 4 (peso 4)
            { INF, INF, 0, INF },// Nodo 3: No tiene aristas
            { INF, INF, 2, 0 }  // Nodo 4: 4 → 3 (peso 2)
        };

        int V = graph.length; // Número de vértices (4 nodos)
        fw.floydWarshall(graph, V); // Ejecutar el algoritmo
    }
}


/*Iteración 1: Usando el nodo 1 como intermediario
Verificamos si el camino de 1 a 4 puede mejorar pasando por el nodo 1.
La distancia directa de 1 a 4 es 5, y no se puede mejorar pasando por el mismo nodo 1, ya que el camino sería simplemente 1 → 4.
No hay cambio en la distancia de 1 a 4.
Iteración 2: Usando el nodo 2 como intermediario
Verificamos si el camino de 1 a 4 puede mejorar pasando por el nodo 2.
El camino de 1 → 2 tiene peso 2, y de 2 → 4 tiene peso 4, lo que da una distancia total de 2 + 4 = 6.
Este nuevo camino tiene una distancia mayor que la distancia directa de 5, por lo que no actualizamos.
Iteración 3: Usando el nodo 3 como intermediario
No hay ningún camino que pase por el nodo 3 y conecte a 1 con 4.
No hay cambio en la distancia de 1 a 4.
Iteración 4: Usando el nodo 4 como intermediario
Verificamos si el camino de 1 a 4 puede mejorar pasando por el nodo 4.
No tiene sentido pasar por el mismo nodo 4 cuando ya tenemos la distancia directa de 1 a 4.
No hay cambio en la distancia de 1 a 4.
Resultado final de la distancia de 1 a 4:
La distancia más corta de 1 a 4 sigue siendo 5, que es la distancia directa inicial.
Al final, tenemos las siguientes distancias más cortas entre todos los pares de nodos:

De 1 a 2: distancia 2 (sin cambios).
De 1 a 3: distancia 7 (encontrado al pasar por el nodo 4).
De 1 a 4: distancia 5 (sin cambios).
De 2 a 3: distancia 6 (encontrado al pasar por el nodo 4).
De 2 a 4: distancia 4 (sin cambios).
De 4 a 3: distancia 2 (sin cambios).
Los demás pares de nodos no tienen caminos posibles y mantienen la distancia infinita.*/
