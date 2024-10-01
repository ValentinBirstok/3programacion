package clase6;

public class actividad63programaciondinamica {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Beneficio máximo: " + dp[n][presupuesto]);
    }

    //complejidad ==> O(N x P)
    // N ==> numero de proyectos
    // ==> presupuesto disponible
}