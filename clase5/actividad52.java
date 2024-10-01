package clase5;

public class actividad52 {
    private int[][] matrizAdyacencia;  //creamos matriz 
    private int numVertices;

    //inicializar el grafo con un número fijo de vértices
    public actividad52(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices]; // la matriz en NxN
    }

    //agrega una arista entre dos vértices
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) { //NOS FIJAMOS QUE EL NUMERO QUE LLEGA COMO PARAMETRO NO SE PASE NI SEA NEGATIVO
            matrizAdyacencia[origen][destino] = 1; //agregamos arista
        }
    }

    //elimina una arista entre dos vértices
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) { //NOS FIJAMOS QUE EL NUMERO QUE LLEGA COMO PARAMETRO NO SE PASE NI SEA NEGATIVO
            matrizAdyacencia[origen][destino] = 0; //sacamos arista
        }
    }

    //verifica si existe una arista entre dos vértices
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) { //NOS FIJAMOS QUE EL NUMERO QUE LLEGA COMO PARAMETRO NO SE PASE NI SEA NEGATIVO
            return matrizAdyacencia[origen][destino] == 1; //si hay conexion, da true
        }
        return false;
    }

    //lista los adyacentes de un vértice
    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) { //que respete limites
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) { //recorremos 
                if (matrizAdyacencia[vertice][i] == 1) { //si hay conexion en la fila de nuestro vertice
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }

    //cuenta el grado de entrada de un vértice
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) { //recorremos
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++; //si hay conexion sumamos 1
                }
            }
        }
        return gradoEntrada;
    }

    //cuenta el grado de salida de un vértice
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) { //recorremos
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++; //si hay conexion sumamos 1
                }
            }
        }
        return gradoSalida;
    }

    //prueba la implementación del grafo
    public static void main(String[] args) {
        actividad52 grafo = new actividad52(5); // Crear un grafo con 5 vértices

        //agrega algunas aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);

        //verifica aristas
        System.out.println("Existe arista entre 0 y 1: " + grafo.verificarArista(0, 1));
        System.out.println("Existe arista entre 1 y 3: " + grafo.verificarArista(1, 3));

        //lista adyacentes de un vértice
        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(2);

        //cuenta grados de entrada y salida
        System.out.println("Grado de entrada de 2: " + grafo.contarGradoEntrada(2));
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0));
    }
}