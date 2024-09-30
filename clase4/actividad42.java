package clase4;

import java.util.Arrays;

public class Actividad42 {

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
