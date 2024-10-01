package clase5;

import clase5.actividad53.Arista;

public class actividad54 {
    
        // Grafo representado como lista de adyacencia
        private final Map<Integer, List<Arista>> grafo;
    
        // Constructor
        public Dijkstra() {
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


}
