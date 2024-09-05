package clase3;

import java.util.Arrays;

public class actividad33 {

    public static void main(String[] args) {
        int[] idclientes = {143, 223, 437, 843, 165};
        String[] nombreclientes = {"juan", "martin", "alberto", "jose", "matias"};
        int[] scoringclientes = {10, 8, 13, 4, 9};

        // Llamada a la función para encontrar los dos máximos
        int[] dosMaximos = scoreMaximo(scoringclientes);

        System.out.println("Scorings máximos: " + dosMaximos[0] + " y " + dosMaximos[1]);

        // Imprimir los detalles de los clientes correspondientes a los dos máximos scorings
        for (int i = 0; i < scoringclientes.length; i++) {
            if (dosMaximos[0] == scoringclientes[i]) {
                System.out.println("El score máximo es " + dosMaximos[0] + " de " + nombreclientes[i] + " cuyo id es " + idclientes[i]);
            } else if (dosMaximos[1] == scoringclientes[i]) {
                System.out.println("El segundo score máximo es " + dosMaximos[1] + " de " + nombreclientes[i] + " cuyo id es " + idclientes[i]);
            }
        }
    }

    // Función para encontrar los dos máximos scorings
    private static int[] scoreMaximo(int[] scoringclientes) {
        return busqDosMaximos(scoringclientes, 0, scoringclientes.length - 1);
    }

    // Función recursiva para encontrar los dos máximos utilizando divide y vencerás
    private static int[] busqDosMaximos(int[] scoringclientes, int inicio, int fin) {
        // Caso base: si solo hay un elemento, devolvemos ese elemento dos veces
        if (inicio == fin) {
            return new int[]{scoringclientes[inicio], scoringclientes[inicio]};
        }

        // Caso base: si hay dos elementos, devolvemos ambos ordenados
        if (fin - inicio == 1) {
            if (scoringclientes[inicio] > scoringclientes[fin]) {
                return new int[]{scoringclientes[inicio], scoringclientes[fin]};
            } else {
                return new int[]{scoringclientes[fin], scoringclientes[inicio]};
            }
        }

        // Dividir el arreglo en dos mitades
        int mitad = (inicio + fin) / 2;
        int[] izqMaximos = busqDosMaximos(scoringclientes, inicio, mitad);
        int[] derMaximos = busqDosMaximos(scoringclientes, mitad + 1, fin);

        // Combinar los dos máximos de cada mitad
        return combinarDosMaximos(izqMaximos, derMaximos);
    }

    // Función para combinar los dos máximos de cada mitad
    private static int[] combinarDosMaximos(int[] izq, int[] der) {
        int mayor1, mayor2;

        // Determinar el mayor entre los dos arreglos
        if (izq[0] > der[0]) {
            mayor1 = izq[0];
            mayor2 = Math.max(izq[1], der[0]);
        } else {
            mayor1 = der[0];
            mayor2 = Math.max(der[1], izq[0]);
        }

        return new int[]{mayor1, mayor2};
    }
}
//análisis de recurrencia 
//caso base ==> n=1 ==> T(1)= C
//Si n=2 ==> T(2)= 2T(1)+C ==> T(2)= 2C + C = 3C
//Si n=4 se divide en 2 subproblemas mas, entonces=
