package clase6;

public class actividad61 {
        public static void main(String[] args) {
            int[] pesos = {3, 4, 2}; // Pesos de los objetos
            int[] valores = {4, 5, 3}; // Valores de los objetos
            int capacidad = 6; // Capacidad de la mochila
    
            int resultado = knapsack(valores, pesos, capacidad);
            System.out.println("Valor máximo en la mochila: " + resultado);
        }
    
        public static int knapsack(int[] valores, int[] pesos, int capacidad) {
            int n = valores.length;
            int[][] dp = new int[n + 1][capacidad + 1];
    
}
