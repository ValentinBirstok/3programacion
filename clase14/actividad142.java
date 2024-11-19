package clase14;

public class actividad142 {

    // Tamaño del tablero y subcuadrantes
    private static final int SIZE = 6;

    // Método para verificar si un número es válido en una fila
    public static boolean esValidoFila(int[][] tablero, int fila, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (tablero[fila][col] == num) {
                return false;
            }
        }
        return true;
    }

    // Método para verificar si un número es válido en una columna
    public static boolean esValidoColumna(int[][] tablero, int col, int num) {
        for (int fila = 0; fila < SIZE; fila++) {
            if (tablero[fila][col] == num) {
                return false;
            }
        }
        return true;
    }

    // Método para verificar si un número es válido en un subcuadrante
    public static boolean esValidoSubcuadrante(int[][] tablero, int fila, int col, int num) {
        int startRow = (fila / 2) * 2;  // Determinar la fila de inicio del subcuadrante
        int startCol = (col / 3) * 3;  // Determinar la columna de inicio del subcuadrante

        // Verificar las 6 celdas dentro del subcuadrante 2x3
        for (int i = startRow; i < startRow + 2; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (tablero[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
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
