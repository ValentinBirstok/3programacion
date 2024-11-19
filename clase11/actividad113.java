package clase11;

public class actividad113 {
    private static final int N = 4; // Tamaño de la oficina (4x4)

    // Método para mostrar una configuración válida del tablero
    private static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("C "); // Computadora
                } else if (tablero[i][j] == 2) {
                    System.out.print("I "); // Impresora
                } else {
                    System.out.print(". "); // Espacio vacío
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Método de backtracking para encontrar todas las posiciones válidas
    private static void colocarComputadorasEImpresoras(int[][] tablero, int filaComputadora, int filaImpresora) {
        // Intentamos colocar las computadoras en las filas
        if (filaComputadora == N) {
            // Si colocamos todas las computadoras, intentamos colocar las impresoras
            if (filaImpresora == N) {
                // Si logramos colocar todas las impresoras, mostramos el tablero
                mostrarTablero(tablero);
            } else {
                // Recorrer todas las posibles columnas para la impresora en la fila actual
                for (int colImpresora = 0; colImpresora < N; colImpresora++) {
                    if (esPosicionValida(tablero, filaImpresora, colImpresora, 2)) {
                        // Colocar la impresora en la posición válida
                        tablero[filaImpresora][colImpresora] = 2;
                        // Intentar colocar la siguiente impresora en la fila siguiente
                        colocarComputadorasEImpresoras(tablero, filaComputadora, filaImpresora + 1);
                        // Retirar la impresora para probar otra posición
                        tablero[filaImpresora][colImpresora] = 0;
                    }
                }
            }
            return;
        }
        // Recorrer todas las posibles columnas para la computadora en la fila actual
        for (int colComputadora = 0; colComputadora < N; colComputadora++) {
            if (esPosicionValida(tablero, filaComputadora, colComputadora, 1)) {
                // Colocar la computadora en la posición válida
                tablero[filaComputadora][colComputadora] = 1;
                // Intentar colocar la siguiente computadora en la fila siguiente
                colocarComputadorasEImpresoras(tablero, filaComputadora + 1, filaImpresora);
                // Retirar la computadora para probar otra posición
                tablero[filaComputadora][colComputadora] = 0;
            }
        }
    }

    // Verificar si una posición es válida para colocar un elemento (computadora o impresora)
    private static boolean esPosicionValida(int[][] tablero, int fila, int columna, int tipoElemento) {
        // Verificar la fila y la columna para el tipo de elemento
        for (int i = 0; i < N; i++) {
            // Evitar la misma fila y la misma columna para computadoras o impresoras
            if (tablero[fila][i] == tipoElemento || tablero[i][columna] == tipoElemento) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] tablero = new int[N][N]; // Inicializar la oficina vacía
        colocarComputadorasEImpresoras(tablero, 0, 0); // Iniciar la búsqueda de soluciones
    }
}