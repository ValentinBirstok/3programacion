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
    //PRUEBA DE ESCRITORIO
    //Jugador 1: Con costo 3 y rendimiento 4:

    //Si el presupuesto es menor a 3, no podemos incluirlo, así que dp[1][j] = 0.
    //A partir de un presupuesto de 3, podemos incluir al jugador y el rendimiento es 4.
    //Jugador 2: Con costo 4 y rendimiento 5:

    //Para un presupuesto de 4, el mejor rendimiento es 5 (fichamos al jugador 2).
    //Para presupuestos mayores, decidimos si fichamos al jugador 2 junto al 1 o solo al 1. Para un presupuesto de 6, podemos fichar al jugador 2 junto al 1 (rendimiento total 9).
    //Jugador 3: Con costo 2 y rendimiento 3:

    //Para un presupuesto de 2, fichamos al jugador 3 y obtenemos 3.
    //Para presupuestos mayores, si fichamos al jugador 1 y al jugador 3, obtenemos 7 (costo total 5).
    //Para un presupuesto de 6, si fichamos a los jugadores 2 y 3, obtenemos un rendimiento total de 8 (costo total 6).
    //Paso 3: Resultado
    //El rendimiento máximo con un presupuesto de 6 es 8, seleccionando a los jugadores 2 y 3 (costo total: 6).

    


