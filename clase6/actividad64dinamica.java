package clase6;

public class actividad64dinamica {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - costos[i - 1]] + ganancias[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Ganancia máxima: " + dp[n][presupuesto]);
    }
}

/*O(n×m), donde 
𝑛
n es el número de paquetes y 
𝑚
m es el presupuesto */