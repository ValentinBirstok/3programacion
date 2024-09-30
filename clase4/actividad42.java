package clase4;

import java.util.Arrays;

public class actividad42 {

    // Método para encontrar el número mínimo de comprobantes para realizar la compra
    public static int minComprobantesGreedy(int valorCompra, int[] comprobantes) {
        // Ordenamos los comprobantes de menor a mayor (orden ascendente)
        Arrays.sort(comprobantes);

        int comprobantesUsados = 0;
        int resto = valorCompra;

        // Recorremos el array desde el final (comprobantes de mayor valor)
        for (int i = comprobantes.length - 1; i >= 0; i--) {
            // Usamos tantos comprobantes de este tipo como sea posible
            while (resto >= comprobantes[i]) {
                resto -= comprobantes[i];
                comprobantesUsados++;
            }
        }
        if (resto == 0) {
            return comprobantesUsados;
        } else {
            // Si no es posible realizar la compra exacta, retornamos -1
            return -1;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] comprobantes = {1, 5, 10, 50, 100};
        int valorCompra = 137;

        int resultado = minComprobantesGreedy(valorCompra, comprobantes);
        if (resultado != -1) {
            System.out.println("Número mínimo de comprobantes utilizados: " + resultado);
        } else {
            System.out.println("No es posible realizar la compra con los comprobantes disponibles.");
        }
    }
}
//COMPLEJIDAD ALGORITMICA
//al tener que hacer un sort, se utiliza O(n log n)
// al estar en la presencia de un ciclo for se utiliza o(n)
