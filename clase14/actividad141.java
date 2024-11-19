package clase14;

public class actividad141 {
    private static final int N = 4; // Tamaño del tablero (4x4)

    // Método para verificar si dos reinas no se atacan
    private static boolean esSeguro(int[][] tablero, int fila1, int col1, int fila2, int col2) {
        // Verificar si están en la misma fila, columna o diagonal
        return fila1 != fila2 && col1 != col2 && Math.abs(fila1 - fila2) != Math.abs(col1 - col2);
        //En ajedrez, dos reinas están en la misma diagonal si la diferencia absoluta entre sus filas es igual a la diferencia absoluta entre sus columnas.
    }

    // Método para mostrar una configuración válida del tablero
    private static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void colocarReinas(int[][] tablero) {
        // Recorrer todas las posibles posiciones para la primera reina
        for (int fila1 = 0; fila1 < N; fila1++) {
            for (int col1 = 0; col1 < N; col1++) {
                // Colocar la primera reina
                tablero[fila1][col1] = 1;

                // Recorrer todas las posibles posiciones para la segunda reina
                for (int fila2 = 0; fila2 < N; fila2++) {
                    for (int col2 = 0; col2 < N; col2++) {
                        // Evitar colocar la segunda reina en la misma posición que la primera
                        if (fila1 == fila2 && col1 == col2) {
                            continue;
                        }

                        // Verificar si las dos reinas no se atacan
                        if (esSeguro(tablero, fila1, col1, fila2, col2)) {
                            // Colocar la segunda reina
                            tablero[fila2][col2] = 1;

                            // Mostrar la configuración válida
                            mostrarTablero(tablero);

                            // Retirar la segunda reina para seguir buscando más soluciones
                            tablero[fila2][col2] = 0;
                        }
                    }
                }

                // Retirar la primera reina para probar en la siguiente posición
                tablero[fila1][col1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] tablero = new int[N][N]; // Inicializar el tablero vacío
        colocarReinas(tablero); // Iniciar la búsqueda de soluciones
    }
}
/* 1) ¿Cómo funciona el backtracking en este problema? El backtracking coloca una reina en una casilla, luego prueba con la siguiente. 
Si encuentra una solución válida, la muestra. Si no puede colocar más reinas sin conflictos, retrocede (elimina la última reina) y prueba nuevas posiciones.

2)¿Qué pasa cuando el algoritmo encuentra una solución?
Cuando el algoritmo coloca una reina en cada fila sin conflictos, imprime el tablero o almacena la solución. Luego puede continuar buscando otras soluciones si el código está adaptado para ello.

3)¿Qué ocurre cuando no puede colocar más reinas?
El algoritmo retrocede al último paso válido y prueba otra columna. Si todas las opciones están agotadas, informa que no hay solución.

4) ¿Qué sucede en el código cuando el algoritmo "retrocede"?
La posición de la reina más reciente se vacía (se asigna -1 en este caso), y el algoritmo vuelve a probar con otra columna en la fila anterior.

5)¿Qué modificaciones harías para aumentar N a 8?
Solo se debe cambiar el valor de n al llamar a la función "8".

6¿Cómo crees que cambiaría el tiempo de ejecución?
Incrementar N aumenta exponencialmente el tiempo, ya que el número de combinaciones posibles crece rápidamente. Esto se debe a que el algoritmo explora todas las posibilidades antes de descartar las inválidas.

7¿Por qué el método isSafe es crucial en este algoritmo?
Este método asegura que las reinas no se ataquen mutuamente, verificando las condiciones en filas, columnas y diagonales. Sin este método, el algoritmo no podría garantizar soluciones válidas.

*/
    

