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
        for (int colEscritorio = 0; colEscritorio < N; colEscritorio++) {
            if (esPosicionValida(tablero, filaEscritorio, colEscritorio, 1)) {
                // Colocar el escritorio en la posición válida
                tablero[filaEscritorio][colEscritorio] = 1;
                // Intentar colocar el siguiente escritorio en la fila siguiente
                colocarEscritoriosYSillas(tablero, filaEscritorio + 1, filaSilla);
                // Retirar el escritorio para probar otra posición
                tablero[filaEscritorio][colEscritorio] = 0;
            }
        }
    }

    // Verificar si una posición es válida para colocar un elemento (escritorio o silla)
    private static boolean esPosicionValida(int[][] tablero, int fila, int columna, int tipoElemento) {
        // Verificar la fila y la columna para el tipo de elemento
        for (int i = 0; i < N; i++) {
            // Evitar la misma fila y la misma columna para escritorios o sillas
            if (tablero[fila][i] == tipoElemento || tablero[i][columna] == tipoElemento) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] tablero = new int[N][N]; // Inicializar la habitación vacía
        colocarEscritoriosYSillas(tablero, 0, 0); // Iniciar la búsqueda de soluciones
    }
}