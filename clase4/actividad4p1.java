package clase4;
import java.util.Arrays;
import java.util.Arrays;

public class actividad4p1 {
    
    public static boolean esCambioPosible(int[] monedas, int monto) {
        Arrays.sort(monedas); 
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i]; 
            }
        }
        return monto == 0; 
    }

    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25};
        int monto = 36;
        boolean resultado = esCambioPosible(monedas, monto);
        if (resultado) {
            System.out.println("Es posible entregar el cambio exacto.");
        } else {
            System.out.println("No es posible entregar el cambio exacto.");
        }
    }
}
//complejidad temporal
//C ==>valor del cambio que se necesita entregar
//1er paso, si se debe ordenar las monedas se usa O(n log n)
//  Al seleccionar las monedas se usa O(m) m==> numero total de monedas
// Finalmente, al verificar si se puede formar el cambio, se usa O(C) 

    
    

