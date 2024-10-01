package clase5;

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

}
