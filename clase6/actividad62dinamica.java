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
/*   Objeto 1: Peso 2 y Valor 4
Para una capacidad menor que 2, no se puede incluir el objeto 1, así que el valor es 0.
A partir de una capacidad de 2 o más, podemos incluir el objeto 1, por lo que el valor será 4 en cada caso.
     Objeto 2: Peso 5 y Valor 2
Para capacidades menores a 5, el mejor valor es el del objeto 1 (4).
A partir de una capacidad de 5, decidimos si incluimos el objeto 2 o mantenemos el objeto 1. El objeto 1 sigue dando más valor (4 vs 2), por lo que optamos por no tomar el objeto 2.
    Objeto 3: Peso 6 y Valor 1
Para capacidades menores a 6, mantenemos los valores de los objetos anteriores (máximo 4).
A partir de una capacidad de 6, no es beneficioso incluir el objeto 3 porque su valor (1) es menor que el valor actual que podemos obtener (4).
    Objeto 4: Peso 7 y Valor 6
Para capacidades menores a 7, el mejor valor sigue siendo el obtenido con el objeto 1 (4).
A partir de una capacidad de 7, decidimos si incluimos el objeto 4. Si lo incluimos, obtenemos un valor de 6.
Para una capacidad de 9 o 10, podemos combinar el objeto 1 (valor 4) con el objeto 4 (valor 6), obteniendo un valor total de 10, que es la mejor opción.

El valor máximo que se puede obtener con una capacidad de 10 es 10, seleccionando el objeto 1 y el objeto 4.*/