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
}
