package clase11;

public class actividad112 {
    private static final int N = 4; // Tamaño de la habitación (4x4)

    // Método para mostrar una configuración válida del tablero
    private static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("E "); // Escritorio
                } else if (tablero[i][j] == 2) {
                    System.out.print("S "); // Silla
                } else {
                    System.out.print(". "); // Espacio vacío
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Método de backtracking para encontrar todas las posiciones válidas
    private static void colocarEscritoriosYSillas(int[][] tablero, int filaEscritorio, int filaSilla) {
        // Intentamos colocar el escritorio en una fila específica
        if (filaEscritorio == N) {
            // Si colocamos todos los escritorios, intentamos colocar las sillas
            if (filaSilla == N) {
                // Si logramos colocar todos los escritorios y sillas correctamente, mostramos el tablero
                mostrarTablero(tablero);
            } else {
                // Recorrer todas las posibles columnas para la silla en la fila actual
                for (int colSilla = 0; colSilla < N; colSilla++) {
                    if (esPosicionValida(tablero, filaSilla, colSilla, 2)) {
                        // Colocar la silla en la posición válida
                        tablero[filaSilla][colSilla] = 2;
                        // Intentar colocar la siguiente silla en la fila siguiente
                        colocarEscritoriosYSillas(tablero, filaEscritorio, filaSilla + 1);
                        // Retirar la silla para probar otra posición
                        tablero[filaSilla][colSilla] = 0;
                    }
                }
            }
            return;
        }
}
