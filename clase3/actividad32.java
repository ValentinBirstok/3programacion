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
            
    
            // Dividir el arreglo en dos mitades
            int medio = arr.length / 2;
            int[] izquierda = Arrays.copyOfRange(arr, 0, medio);
            int[] derecha = Arrays.copyOfRange(arr, medio, arr.length);
            
            // Recursivamente encontrar los dos mayores en cada mitad
        int[] mayoresIzquierda = encontrarDosMayores(izquierda);
        int[] mayoresDerecha = encontrarDosMayores(derecha);

        // Combinar los resultados de ambas mitades
        return combinarDosMayores(mayoresIzquierda, mayoresDerecha);
    }

    // Función para combinar los resultados de las dos mitades
    private static int[] combinarDosMayores(int[] izq, int[] der) {
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
        int[] numeros = {10, 20, 5, 3, 100, 50, 25};
        int[] resultado = encontrarDosMayores(numeros);
        
        System.out.println("El mayor es: " + resultado[0]);
        System.out.println("El segundo mayor es: " + resultado[1]);
    }
}

}
}