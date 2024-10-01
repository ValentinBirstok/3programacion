package clase5;

public class actividad52 {
    private int[][] matrizAdyacencia;
    private int numVertices;

    //inicializar el grafo con un número fijo de vértices
    public actividad52(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    //agrega una arista entre dos vértices
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        }
    }

    //elimina una arista entre dos vértices
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
        }
    }

    //verifica si existe una arista entre dos vértices
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;
        }
        return false;
    }

    //lista los adyacentes de un vértice
    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }}}