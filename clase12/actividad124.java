package clase12;

import java.util.*;

class Usuario {
    private int id;        // Identificador único del usuario
    private String nombre; // Nombre del usuario

    // Constructor
    public Usuario(int id, String nombre) {
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
        return nombre + " (ID: " + id + ")";
    }
}

class RedSocial {
    private Map<Integer, Usuario> usuarios;               // Mapa de usuarios por ID
    private Map<Integer, List<Integer>> listaAdyacencia;  // Lista de adyacencia para amistades

    // Constructor
    public RedSocial() {
        usuarios = new HashMap<>();
        listaAdyacencia = new HashMap<>();
    }

    // Método para agregar un usuario a la red
    public void agregarUsuario(int id, String nombre) {
        if (!usuarios.containsKey(id)) {
            Usuario usuario = new Usuario(id, nombre);
            usuarios.put(id, usuario);
            listaAdyacencia.put(id, new ArrayList<>());
        }
    }

    // Método para conectar dos usuarios como amigos (amistad bidireccional)
    public void conectarAmigos(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            listaAdyacencia.get(id1).add(id2);
            listaAdyacencia.get(id2).add(id1); // Relación bidireccional
        }
    }

    public void DFS(int idInicial) {
        if (!usuarios.containsKey(idInicial)) return;

        Set<Integer> visitado = new HashSet<>();
        System.out.println("Recorrido DFS desde " + usuarios.get(idInicial) + ":");
        DFSRecursivo(idInicial, visitado);
        System.out.println(); // Nueva línea al finalizar el recorrido
    }

    // Método recursivo para DFS
    private void DFSRecursivo(int id, Set<Integer> visitado) {
        visitado.add(id);
        System.out.print(usuarios.get(id) + " -> ");

        // Explorar amigos no visitados
        for (int amigo : listaAdyacencia.get(id)) {
            if (!visitado.contains(amigo)) {
                DFSRecursivo(amigo, visitado);
            }
        }
    }

    // Método para realizar un recorrido BFS desde un usuario dado
    public void BFS(int idInicial) {
        if (!usuarios.containsKey(idInicial)) return;

        Queue<Integer> cola = new LinkedList<>();
        Set<Integer> visitado = new HashSet<>();

        // Iniciar el BFS
        cola.offer(idInicial);
        visitado.add(idInicial);

        System.out.println("Recorrido BFS desde " + usuarios.get(idInicial) + ":");
        while (!cola.isEmpty()) {
            int id = cola.poll();
            System.out.print(usuarios.get(id) + " -> ");

            // Explorar amigos no visitados
            for (int amigo : listaAdyacencia.get(id)) {
                if (!visitado.contains(amigo)) {
                    visitado.add(amigo);
                    cola.offer(amigo);
                }
            }
        }
        System.out.println(); // Nueva línea al finalizar el recorrido
    }
}

public class actividad124 {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // Agregar usuarios a la red
        red.agregarUsuario(1, "Alice");
        red.agregarUsuario(2, "Bob");
        red.agregarUsuario(3, "Charlie");
        red.agregarUsuario(4, "David");
        red.agregarUsuario(5, "Eve");

        // Conectar usuarios como amigos
        red.conectarAmigos(1, 2);
        red.conectarAmigos(1, 3);
        red.conectarAmigos(2, 4);
        red.conectarAmigos(3, 5);
        red.conectarAmigos(4, 5);

        // Realizar recorridos desde el usuario "Alice" (ID 1)
        red.DFS(1);
        red.BFS(1);
    }
}