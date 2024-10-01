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
         // Si podemos incluir el objeto actual sin exceder la capacidad
         if (pesoActual + pesos[i] <= capacidad) {
            // Opción 1: Tomamos el objeto actual y agregamos su valor
            int tomar = valores[i] + fuerzaBruta(i + 1, pesoActual + pesos[i]);
            // Opción 2: No tomamos el objeto actual
            int noTomar = fuerzaBruta(i + 1, pesoActual);
            // Retornar el máximo valor entre tomar o no tomar el objeto
            return Math.max(tomar, noTomar);
        } else {
            // Si no podemos incluir el objeto, pasamos al siguiente
            return fuerzaBruta(i + 1, pesoActual);
        }
    }

    public static void main(String[] args) {
        // Llamar a la función de fuerza bruta para encontrar el valor máximo
        int resultado = fuerzaBruta(0, 0);
        // Mostrar el resultado
        System.out.println("El valor máximo usando fuerza bruta es: " + resultado);
    }
}