package clase3;
import java.util.Arrays;

public class NMayoresDivideVenceras {

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

        // Caso base: si hay menos elementos de los que queremos encontrar, devolvemos todos los disponibles
        if (fin - inicio + 1 <= n) {
            int[] resultado = Arrays.copyOfRange(lista, inicio, fin + 1);
            Arrays.sort(resultado); // Ordenamos los elementos
            return invertirArray(resultado); // Invertimos el arreglo para obtener los mayores primero
        }

        // Dividimos el array en dos mitades
        int mitad = (inicio + fin) / 2;
        int[] izqMayores = busqNMayores(lista, inicio, mitad, n);
        int[] derMayores = busqNMayores(lista, mitad + 1, fin, n);

        // Combinamos los n mayores de ambas mitades
        return combinarNMayores(izqMayores, derMayores, n);
    }

    // Función para combinar los n mayores de las dos mitades
    private static int[] combinarNMayores(int[] izq, int[] der, int n) {
        int[] combinados = new int[Math.min(izq.length + der.length, n)]; // Combinaremos hasta n elementos
        int i = 0, j = 0, k = 0;

        // Combinamos ambas mitades ordenadamente, eligiendo siempre el mayor disponible
        while (i < izq.length && j < der.length && k < n) {
            if (izq[i] > der[j]) {
                combinados[k++] = izq[i++];
            } else {
                combinados[k++] = der[j++];
            }
        }

        // Si aún quedan elementos en la mitad izquierda, los añadimos
        while (i < izq.length && k < n) {
            combinados[k++] = izq[i++];
        }

        // Si aún quedan elementos en la mitad derecha, los añadimos
        while (j < der.length && k < n) {
            combinados[k++] = der[j++];
        }

        return combinados;
    }

    // Función para invertir un array (para obtener los elementos mayores al inicio)
    private static int[] invertirArray(int[] array) {
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - 1 - i];
        }
        return invertido;
    }
}

