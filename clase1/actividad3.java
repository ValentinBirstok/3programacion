package clase1;
import java.util.Scanner;

public class actividad3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 
        System.out.println("Ingrese cantidad que quiera sumar");
        int cantidad=sc.nextInt();
        System.out.println("La suma de los numeros enteros hasta "+ cantidad +" es: "+sumarnumeros(cantidad));
        
    }
    public static int sumarnumeros(int cantidad){
        if (cantidad==1) {
            return 1;
            
            
        }
        return cantidad+sumarnumeros(cantidad-1);
    }
    
}
