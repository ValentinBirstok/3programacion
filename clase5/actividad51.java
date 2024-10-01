package clase5;
import java.util.*;

class RedSocial {
    private Map<String, List<String>> listaAdyacencia; //creamos lista de adyacencia

    public RedSocial() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(String usuario) {
        if (!listaAdyacencia.containsKey(usuario)) {   //verificamos que el usuario no se encuentre
            listaAdyacencia.put(usuario, new ArrayList<>());    //Si no se encuentra, agreagamos usuario
        }
    }

    // Seguir a otro usuario
    public void seguir(String seguidor, String seguido) {
        if (listaAdyacencia.containsKey(seguidor) && listaAdyacencia.containsKey(seguido)) {  //verificamos que los dos usuarios se encuentren en el sistema
            List<String> listaSeguidores = listaAdyacencia.get(seguidor); //obtener la lista de usuarios a los que un usuario seguidor sigue
            if (!listaSeguidores.contains(seguido)) { //si el usuario todavia no sigue al seguidor, lo empieza a seguir
                listaSeguidores.add(seguido);
            }
        }
    }

    // Dejar de seguir a otro usuario
    public void dejarDeSeguir(String seguidor, String seguido) {
        if (listaAdyacencia.containsKey(seguidor)) {    //si esta el usuario en el sistema
            List<String> listaSeguidores = listaAdyacencia.get(seguidor);  ////obtener la lista de usuarios a los que un usuario seguidor sigue
            listaSeguidores.remove(seguido); //eliminamos el usuario de la lista de adyacencia
        }
    }

    // Obtener la lista de usuarios que sigue un usuario dado
    public List<String> obtenerSeguidos(String usuario) {
        return listaAdyacencia.getOrDefault(usuario, new ArrayList<>());    //devovemos la lista de seguidores de un usuario que llega como parametro
    }

public List<String> obtenerSeguidores(String usuario) {
    List<String> seguidores = new ArrayList<>();
    for (Map.Entry<String, List<String>> entrada : listaAdyacencia.entrySet()) {
        if (entrada.getValue().contains(usuario)) {
            seguidores.add(entrada.getKey());   //vamos agregando las personas que siguen a nuestro usuario a una List
        }
    }
    return seguidores;
}

public static void main(String[] args) {
    RedSocial red = new RedSocial();

    // Agregar usuarios
    red.agregarUsuario("Pedro");
    red.agregarUsuario("Olga");
    red.agregarUsuario("Horacio");

    // Operaciones de seguimiento
    red.seguir("Pedro", "Olga");
    red.seguir("Pedro", "Horacio");
    red.seguir("Olga", "Horacio");

    // Mostrar usuarios que sigue Pedro
    System.out.println("Pedro sigue a: " + red.obtenerSeguidos("Pedro"));

    // Mostrar seguidores de Horacio
    System.out.println("Horacio es seguido por: " + red.obtenerSeguidores("Horacio"));

    // Dejar de seguir
    red.dejarDeSeguir("Pedro", "Olga");
    System.out.println("Después de dejar de seguir a Olga:");
    System.out.println("Pedro sigue a: " + red.obtenerSeguidos("Pedro"));
    System.out.println("Olga es seguido por: " + red.obtenerSeguidores("Olga"));
}
}
