package clase4;
import java.util.Arrays;



public class actividad44 {

    public static int getMinimumCost(int[] c, int k) {
        
        Arrays.sort(c); // Ordenar el arreglo de precios de flores en orden ascendente
        int totalCost = 0;
        int n = c.length;
        
        
        for (int i = n - 1; i >= 0; i--) {
            // Calcular el costo total de la flor actual considerando cuántas flores ha comprado el amigo
            totalCost += ((n - 1 - i) / k + 1) * c[i];
        }
        
        return totalCost; // Devolver el costo total acumulado
    
    }

    public static void main(String[] args) {
        
        int[] c = {2,5,6}; 
        int k = 3; 
        
        int result = getMinimumCost(c, k);
        System.out.println("El costo mínimo es: " + result); 
    }
}