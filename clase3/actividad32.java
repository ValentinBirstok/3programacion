package clase3;

import java.util.Arrays;

public class actividad32 {
    
        public static int[] encontrarDosMayores(int[] arr) {
            // Caso base: si el arreglo tiene solo dos elementos, devolverlos
            if (arr.length == 2) {
                int mayor1, mayor2;
                if (arr[0] > arr[1]) {
                    mayor1 = arr[0];
                    mayor2 = arr[1];
                } else {
                    mayor1 = arr[1];
                    mayor2 = arr[0];
                }
                return new int[]{mayor1, mayor2};
            }
    
            // Si solo hay un número en la lista
            if (arr.length == 1) {
                return new int[]{arr[0], arr[0]}; // Si solo hay un número, devolverlo dos veces
            }
            return new int[0];
    
            // Dividir el arreglo en dos mitades
            int medio = arr.length / 2;
            int[] izquierda = Arrays.copyOfRange(arr, 0, medio);
            int[] derecha = Arrays.copyOfRange(arr, medio, arr.length);

}
}