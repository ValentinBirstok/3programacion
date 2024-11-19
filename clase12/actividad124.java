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
