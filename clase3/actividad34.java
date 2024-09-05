package clase3;
import java.util.Arrays;

public class actividad34 {

    public static void main(String[] args) {
        int[] lista = {10, 20, 5, 3, 100, 50, 25};
        int n = 3; // Número de elementos más grandes que queremos encontrar

        // Llamada a la función para encontrar los n elementos más grandes
        int[] mayoresN = encontrarNMayores(lista, n);

        // Imprimir los n elementos más grandes
        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(mayoresN));
    }

    // Función principal que llama a la recursiva para encontrar los n más grandes
    public static int[] encontrarNMayores(int[] lista, int n) {
        return busqNMayores(lista, 0, lista.length - 1, n);
    }

    // Función recursiva para encontrar los n más grandes usando divide y vencerás
    private static int[] busqNMayores(int[] lista, int inicio, int fin, int n) {
        // Caso base: si hay un solo elemento, devolvemos el elemento en un arreglo
        if (inicio == fin) {
            return new int[]{lista[inicio]};
        }
return new int[0];

    
}
}
