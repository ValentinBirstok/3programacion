package clase15;

public class actividad151 {
    // Método para resolver el Sudoku utilizando backtracking
    public static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < SIZE; fila++) {
            for (int col = 0; col < SIZE; col++) {
                if (tablero[fila][col] == 0) { // Si la celda está vacía
                    for (int num = 1; num <= SIZE; num++) { // Probar números del 1 al 6
                        // Verificar si el número es válido en fila, columna y subcuadrante
                        if (esValidoFila(tablero, fila, num) && esValidoColumna(tablero, col, num) && esValidoSubcuadrante(tablero, fila, col, num)) {
                            tablero[fila][col] = num;

                            // Recursión para colocar el siguiente número
                            if (resolverSudoku(tablero)) {
                                return true;
                            }

                            // Si no se puede resolver, deshacer y probar con el siguiente número
                            tablero[fila][col] = 0;
                        }
                    }
                    return false; // Si no se puede colocar ningún número, retroceder
                }
            }
        }
        return true; // Si se completaron todas las celdas, el Sudoku está resuelto
    }

    // Método para mostrar el tablero
    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
