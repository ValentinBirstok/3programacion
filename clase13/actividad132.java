package clase13;

import java.util.*;

class Grafo {
    private Map<String, Map<String, Integer>> adyacencia;

    // Constructor del grafo
    public Grafo() {
        adyacencia = new HashMap<>();
    }

    // Agregar un destino al grafo
    public void agregarDestino(String destino) {
        adyacencia.putIfAbsent(destino, new HashMap<>());
    }

    // Conectar dos destinos con un costo
    public void conectarDestinos(String origen, String destino, int costo) {
        adyacencia.get(origen).put(destino, costo);
        adyacencia.get(destino).put(origen, costo); // Si las rutas son bidireccionales
    }

    // Obtener los vecinos de un nodo
    public Set<String> obtenerVecinos(String nodo) {
        return adyacencia.get(nodo).keySet();
    }

    // Obtener el costo de viajar entre dos nodos
    public int obtenerCosto(String origen, String destino) {
        return adyacencia.get(origen).get(destino);
    }
}   
class ColaPrioridad {
    private PriorityQueue<Nodo> cola;

    // Constructor de la cola de prioridad
    public ColaPrioridad() {
        cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
    }

    // Insertar un nodo con un costo
    public void insertar(String nodo, int costo) {
        cola.add(new Nodo(nodo, costo));
    }

    // Extraer el nodo con el menor costo
    public Nodo extraerMin() {
        return cola.poll();
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return cola.isEmpty();
    }

    // Clase Nodo
    static class Nodo {
        String nombre;
        int costo;

        Nodo(String nombre, int costo) {
            this.nombre = nombre;
            this.costo = costo;
        }
    }
}
class UCS {
    // Método de búsqueda de costo uniforme (UCS)
    public static String ucs(Grafo grafo, String nodoInicial, String nodoObjetivo) {
        ColaPrioridad colaPrioridad = new ColaPrioridad();
        Map<String, Integer> costosMin = new HashMap<>();

        // Insertar nodo inicial con costo 0
        colaPrioridad.insertar(nodoInicial, 0);
        costosMin.put(nodoInicial, 0);

        // Mientras haya nodos en la cola
        while (!colaPrioridad.estaVacia()) {
            ColaPrioridad.Nodo nodoActual = colaPrioridad.extraerMin();
            String nodo = nodoActual.nombre;
            int costoActual = nodoActual.costo;

            // Si llegamos al nodo objetivo, devolver el costo
            if (nodo.equals(nodoObjetivo)) {
                return "Costo total: " + costoActual;
            }

            // Explorar los vecinos del nodo actual
            for (String vecino : grafo.obtenerVecinos(nodo)) {
                int costoVecino = costoActual + grafo.obtenerCosto(nodo, vecino);

                // Si el costo para llegar al vecino es menor que el conocido
                if (!costosMin.containsKey(vecino) || costoVecino < costosMin.get(vecino)) {
                    costosMin.put(vecino, costoVecino);
                    colaPrioridad.insertar(vecino, costoVecino);
                }
            }
        }

        // Si no se encuentra un camino
        return "No se encontró un camino";
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        // Crear el grafo de destinos
        Grafo grafo = new Grafo();
        grafo.agregarDestino("A");
        grafo.agregarDestino("B");
        grafo.agregarDestino("C");
        grafo.agregarDestino("D");
        grafo.agregarDestino("E");
;

        // Conectar destinos con rutas y costos
        grafo.conectarDestinos("A", "B", 10);
        grafo.conectarDestinos("A", "C", 15);
        grafo.conectarDestinos("B", "D", 5);
        grafo.conectarDestinos("C", "D", 10);
        grafo.conectarDestinos("D", "E", 5);

        // Ejecutar UCS para encontrar el costo mínimo
        String resultado = UCS.ucs(grafo, "A", "E");
        System.out.println(resultado);  // Ejemplo: Costo total:  20
    }
}