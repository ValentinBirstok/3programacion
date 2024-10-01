import java.util.*;

class actividad54 {
    // Grafo representado como lista de adyacencia
    private final Map<Integer, List<Arista>> grafo;

    // Constructor
    public actividad54() {
        this.grafo = new HashMap<>();
    }

    // Método para añadir una arista al grafo
    public void agregarArista(int origen, int destino, int peso) {
        this.grafo.putIfAbsent(origen, new ArrayList<>());
        this.grafo.putIfAbsent(destino, new ArrayList<>());
        this.grafo.get(origen).add(new Arista(destino, peso));
    }

    // Implementación del algoritmo de Dijkstra
    public void dijkstra(int s) {
        // Inicialización
        int numVertices = grafo.size();
        int[] dist = new int[numVertices]; // Distancias desde el origen
        int[] prev = new int[numVertices]; // Predecesores de cada vértice
        boolean[] inMST = new boolean[numVertices]; // Verifica si el vértice está en el MST

        // Inicializar distancias a ∞ y prev a NIL
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[s] = 0; // La distancia al vértice de origen es 0

        // Crear una cola de prioridad Q y añadir todos los vértices
        PriorityQueue<Nodo> Q = new PriorityQueue<>(Comparator.comparingInt(nodo -> nodo.distancia));
        for (int v : grafo.keySet()) {
            Q.add(new Nodo(v, dist[v]));
        }

        // Mientras la cola no esté vacía
        while (!Q.isEmpty()) {
            // Extraer el vértice u con la distancia mínima
            Nodo nodoActual = Q.poll();
            int u = nodoActual.vertice;

            // Si u ya está en el MST, continuar
            if (inMST[u]) continue;

            // Marcar u como incluido en el MST
            inMST[u] = true;

            // Recorrer cada vecino v de u
            for (Arista arista : grafo.getOrDefault(u, new ArrayList<>())) {
                int v = arista.destino;
                int peso = arista.peso;

                // Calcular la distancia alternativa
                int alt = dist[u] + peso;

                // Relajación
                if (alt < dist[v]) {
                    dist[v] = alt;
                    prev[v] = u;
                    Q.add(new Nodo(v, dist[v])); // Actualiza la cola de prioridad
                }
            }
        }

        // Mostrar los resultados
        mostrarResultados(dist, prev, s);
    }

    // Método para mostrar los resultados
    private void mostrarResultados(int[] dist, int[] prev, int inicio) {
        System.out.println("Distancias desde el vértice de origen " + inicio + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distancia a " + i + ": " + dist[i]);
        }
        System.out.println("Predecesores:");
        for (int i = 0; i < prev.length; i++) {
            System.out.println("Predecesor de " + i + ": " + (prev[i] == -1 ? "NIL" : prev[i]));
        }
    }

    // Clase interna para representar aristas
    private static class Arista {
        int destino;
        int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Clase interna para la cola de prioridad
    private static class Nodo {
        int vertice;
        int distancia;

        public Nodo(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }

    public static void main(String[] args) {
        actividad54 dijkstra = new actividad54();
        // Añadir aristas (ejemplo)
        dijkstra.agregarArista(0, 1, 10);
        dijkstra.agregarArista(0, 2, 5);
        dijkstra.agregarArista(1, 2, 2);
        dijkstra.agregarArista(1, 3, 1);
        dijkstra.agregarArista(2, 1, 3);
        dijkstra.agregarArista(2, 3, 9);
        dijkstra.agregarArista(2, 4, 2);
        dijkstra.agregarArista(3, 4, 4);
        dijkstra.agregarArista(4, 3, 6);

        // Ejecutar el algoritmo de Dijkstra desde el centro de distribución principal (vértice 0)
        dijkstra.dijkstra(0);
    }
}


