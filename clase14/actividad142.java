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
    