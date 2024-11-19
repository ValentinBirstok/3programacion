package clase11;

public class actividad111 {
    private static final int N = 4; // Tamaño del tablero (4x4)

    // Método para verificar si dos reinas no se atacan
    private static boolean esSeguro(int[][] tablero, int fila1, int col1, int fila2, int col2) {
        // Verificar si están en la misma fila, columna o diagonal
        return fila1 != fila2 && col1 != col2 && Math.abs(fila1 - fila2) != Math.abs(col1 - col2);
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
}
