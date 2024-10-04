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
                        //el valor máximo que se puede obtener con los objetos que consideramos antes del objeto actual
                        //y la capacidad restante de la mochila después de incluir el objeto actual.
                    } else {
                        dp[i][w] = dp[i - 1][w]; // No incluir el objeto
                    }
                }
            }
    
            return dp[n][capacidad]; // Valor máximo
        }
    }
    /*Prueba de Escritorio
    Objeto 1: Con costo 3 y valor 4.
    Objeto 2: Con costo 4 y valor 5.
    Objeto 3: Con costo 2 y valor 3.
    Descripción de la Prueba
    Objeto 1 (Costo 3, Valor 4):
    Si la capacidad es menor a 3, no podemos incluirlo, así que dp[1][j] = 0.
    A partir de una capacidad de 3, podemos incluir el objeto y el valor total es 4.
    
    Objeto 2 (Costo 4, Valor 5):
    Para una capacidad de 4, el mejor valor es 5 (fichamos el objeto 2).
    Para capacidades mayores, decidimos si incluimos el objeto 2 junto con el objeto 1 o solo el objeto 1. 
    Sin embargo, para una capacidad de 6, no podemos incluir el objeto 2 junto con el objeto 1, ya que su costo total sería 7, lo que excede la capacidad.

    Objeto 3 (Costo 2, Valor 3):
    Para una capacidad de 2, incluimos el objeto 3 y obtenemos 3.
    Para capacidades mayores, si incluimos el objeto 1 y el objeto 3, obtenemos 7 (costo total 5).
    Para una capacidad de 6, si incluimos los objetos 2 y 3, obtenemos un valor total de 8 (costo total 6).
    
    Resultado Final
    Valor Máximo: Con una capacidad de 6, el valor máximo alcanzable es 8, seleccionando los objetos 2 y 3 (costo total: 6).*/

    


