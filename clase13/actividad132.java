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