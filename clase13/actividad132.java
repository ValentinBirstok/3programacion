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