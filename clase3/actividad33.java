package clase3;

import java.util.Arrays;

public class actividad33 {
    public static int[] encontrarDosScoringsMaximos(int[] scorings) {
        // Caso base: si el arreglo tiene solo dos elementos, devolverlos
        if (scorings.length == 2) {
            int mayor1, mayor2;
            if (scorings[0] > scorings[1]) {
                mayor1 = scorings[0];
                mayor2 = scorings[1];
            } else {
                mayor1 = scorings[1];
                mayor2 = scorings[0];
            }
            return new int[]{mayor1, mayor2};
        }

        // Si solo hay un número en la lista
        if (scorings.length == 1) {
            return new int[]{scorings[0], scorings[0]}; // Si solo hay un número, devolverlo dos veces
        }

        // Dividir el arreglo en dos mitades
        int medio = scorings.length / 2;
        int[] izquierda = Arrays.copyOfRange(scorings, 0, medio);
        int[] derecha = Arrays.copyOfRange(scorings, medio, scorings.length);

        // Recursivamente encontrar los dos máximos scorings en cada mitad
        int[] mayoresIzquierda = encontrarDosScoringsMaximos(izquierda);
        int[] mayoresDerecha = encontrarDosScoringsMaximos(derecha);

        // Combinar los resultados de ambas mitades
        return combinarDosScoringsMaximos(mayoresIzquierda, mayoresDerecha);
    }

    // Función para combinar los dos máximos scorings de las dos mitades
    private static int[] combinarDosScoringsMaximos(int[] izq, int[] der) {
        int mayor1, mayor2;

        // Encontrar el mayor entre los dos arreglos
        if (izq[0] > der[0]) {
            mayor1 = izq[0];
            if (izq[1] > der[0]) {
                mayor2 = izq[1];
            } else {
                mayor2 = der[0];
            }
        } else {
            mayor1 = der[0];
            if (der[1] > izq[0]) {
                mayor2 = der[1];
            } else {
                mayor2 = izq[0];
            }
        }

        return new int[]{mayor1, mayor2};
    }

    public static void main(String[] args) {
        int[] scorings = {10, 20, 5, 3, 100, 50, 25};
        int[] resultado = encontrarDosScoringsMaximos(scorings);
        
        System.out.println("El scoring mayor es: " + resultado[0]);
        System.out.println("El segundo scoring mayor es: " + resultado[1]);
    }
}

