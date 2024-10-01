package clase6;

public class actividad62dinamica {
    // Pesos de los objetos
    static int[] pesos = {2, 5, 6, 7};  // Pesos de los objetos disponibles
    // Valores de los objetos
    static int[] valores = {4, 2, 1, 6};  // Valores de los objetos disponibles
    // Capacidad máxima de la mochila
    static int capacidad = 10;  // Capacidad máxima de la mochila
    // Número de objetos
    static int n = pesos.length;  // Número de objetos

    // Función para calcular el valor máximo usando programación dinámica
    public static int programacionDinamica() {
        // Crear una tabla dp donde dp[i][w] almacena el valor máximo para los primeros i objetos con capacidad w
        int[][] dp = new int[n + 1][capacidad + 1];  // Tabla dinámica de tamaño (n+1) x (capacidad+1)

        // Iterar sobre todos los objetos
        for (int i = 1; i <= n; i++) {
            // Iterar sobre todas las capacidades desde 1 hasta la capacidad máxima
            for (int w = 1; w <= capacidad; w++) {
                // Si el objeto i puede ser incluido (peso del objeto <= capacidad actual w)
                if (pesos[i - 1] <= w) {
                    // dp[i][w] es el máximo entre no incluir el objeto o incluirlo
                    dp[i][w] = Math.max(dp[i - 1][w], valores[i - 1] + dp[i - 1][w - pesos[i - 1]]);
                } else {
                    // Si no podemos incluir el objeto, el valor máximo sigue siendo el de la fila anterior
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El valor máximo para los n objetos y capacidad máxima estará en dp[n][capacidad]
        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        // Llamar a la función de programación dinámica para encontrar el valor máximo
        int resultado = programacionDinamica();
        // Mostrar el resultado
        System.out.println("El valor máximo usando programación dinámica es: " + resultado);
    }
}