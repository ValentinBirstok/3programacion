package clase3;

import java.util.Arrays;

public class actividad33 {
    public class DosScoringsMaximos {

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
    
        // Función para encontrar los dos máximos scorings
        private static int[] scoreMaximo(int[] scoringclientes) {
            return busqDosMaximos(scoringclientes, 0, scoringclientes.length - 1);
        }
    
        // Función recursiva para encontrar los dos máximos utilizando divide y vencerás
        private static int[] busqDosMaximos(int[] scoringclientes, int inicio, int fin) {
            // Caso base: si solo hay un elemento, devolvemos el mismo valor dos veces
            if (inicio == fin) {
                return new int[]{scoringclientes[inicio], Integer.MIN_VALUE};
            }return new int[0];
}}}