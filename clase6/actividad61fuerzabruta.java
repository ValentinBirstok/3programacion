package clase6;

public class actividad61fuerzabruta {
    public static void main(String[] args) {
        int[] costos = {3, 4, 2}; // Costo de los jugadores
        int[] valores = {4, 5, 3}; // Valor de los jugadores
        int capacidad = 6; // Presupuesto máximo
        int n = valores.length;

        int mejorValor = 0; // Mejor valor encontrado
        String mejorCombinacion = ""; // Combinación que da el mejor valor
    
         // Evaluar todas las combinaciones de jugadores
         for (int i = 0; i < (1 << n); i++) { // 2^n combinaciones
            int costoTotal = 0;
            int valorTotal = 0;
            String combinacion = "Comprar: ";

            for (int j = 0; j < n; j++) {
                // Verificar si el jugador j está incluido en la combinación
                if ((i & (1 << j)) > 0) {
                    costoTotal += costos[j];
                    valorTotal += valores[j];
                    combinacion += "Jugador " + (j + 1) + ", "; // Concatenar cadena
                }
            }
}
