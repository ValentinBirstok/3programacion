package clase12;

import java.util.*;

class Almacen {
    private int id;       // Identificador único del almacén
    private String nombre; // Nombre del almacén

    // Constructor
    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Almacén " + id + ": " + nombre;
    }
}

class Grafo {
    private Map<Integer, Almacen> almacenes;                  // Mapa de almacenes por ID
    private Map<Integer, List<Integer>> listaAdyacencia;      // Lista de adyacencia

    // Constructor
    public Grafo() {
        almacenes = new HashMap<>();
        listaAdyacencia = new HashMap<>();
    }

    // Método para agregar un almacén al grafo
    public void agregarAlmacen(int id, String nombre) {
        if (!almacenes.containsKey(id)) {
            Almacen almacen = new Almacen(id, nombre);
            almacenes.put(id, almacen);
            listaAdyacencia.put(id, new ArrayList<>());
        }
    }

    // Método para conectar dos almacenes mediante una ruta directa
    public void conectarAlmacenes(int idOrigen, int idDestino) {
        if (almacenes.containsKey(idOrigen) && almacenes.containsKey(idDestino)) {
            listaAdyacencia.get(idOrigen).add(idDestino);
        }
    }

    // Método para realizar un recorrido DFS desde un almacén de inicio
    public void DFS(int idInicial) {
        if (!almacenes.containsKey(idInicial)) return;

        Set<Integer> visitado = new HashSet<>();
        System.out.println("Recorrido DFS desde " + almacenes.get(idInicial) + ":");
        DFSRecursivo(idInicial, visitado);
        System.out.println(); // Nueva línea al finalizar el recorrido
    }

    // Método recursivo para DFS
    private void DFSRecursivo(int id, Set<Integer> visitado) {
        visitado.add(id);
        System.out.print(almacenes.get(id) + " -> ");

        // Explorar vecinos no visitados
        for (int vecino : listaAdyacencia.get(id)) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }