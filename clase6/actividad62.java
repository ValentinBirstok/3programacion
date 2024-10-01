package clase6;

public class actividad62 {
    
    static int[] pesos = {2, 5, 6, 7};  // Pesos de los objetos 
    
    static int[] valores = {4, 2, 1, 6};  // Valores de los objetos 
    
    static int capacidad = 10;  // Capacidad máxima
    
    static int n = pesos.length;  // Número de objetos

    
    public static int fuerzaBruta(int i, int pesoActual) {
        // Caso base: Si hemos considerado todos los objetos, el valor total es 0
        if (i == n) {
            return 0;
        }
