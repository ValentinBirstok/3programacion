package clase5;
import java.util.*;

class RedSocial {
    private Map<String, List<String>> listaAdyacencia;

    public RedSocial() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(String usuario) {
        if (!listaAdyacencia.containsKey(usuario)) {
            listaAdyacencia.put(usuario, new ArrayList<>());
        }
    }

    // Seguir a otro usuario
    public void seguir(String seguidor, String seguido) {
        if (listaAdyacencia.containsKey(seguidor) && listaAdyacencia.containsKey(seguido)) {
            List<String> listaSeguidores = listaAdyacencia.get(seguidor);
            if (!listaSeguidores.contains(seguido)) {
                listaSeguidores.add(seguido);
            }
        }
    }

    // Dejar de seguir a otro usuario
    public void dejarDeSeguir(String seguidor, String seguido) {
        if (listaAdyacencia.containsKey(seguidor)) {
            List<String> listaSeguidores = listaAdyacencia.get(seguidor);
            listaSeguidores.remove(seguido);
        }
    }

    // Obtener la lista de usuarios que sigue un usuario dado
    public List<String> obtenerSeguidos(String usuario) {
        return listaAdyacencia.getOrDefault(usuario, new ArrayList<>());
    }
}