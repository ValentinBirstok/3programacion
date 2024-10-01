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

            // Llenar la tabla dp
            for (int i = 0; i <= n; i++) {
                for (int w = 0; w <= capacidad; w++) {
                    if (i == 0 || w == 0) {
                        dp[i][w] = 0; // Base: sin objetos o sin capacidad
                    } else if (pesos[i - 1] <= w) {
                        dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                    } else {
                        dp[i][w] = dp[i - 1][w]; // No incluir el objeto
                    }
                }
            }
    
            return dp[n][capacidad]; // Valor máximo
        }
    }