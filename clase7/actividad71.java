package clase7;

public class actividad71 {
    public static void main(String[] args) {
        
    }
    

}
/*Iteración 1: Usando el nodo 1 como intermediario
Verificamos si el camino de 1 a 4 puede mejorar pasando por el nodo 1.
La distancia directa de 1 a 4 es 5, y no se puede mejorar pasando por el mismo nodo 1, ya que el camino sería simplemente 1 → 4.
No hay cambio en la distancia de 1 a 4.
Iteración 2: Usando el nodo 2 como intermediario
Verificamos si el camino de 1 a 4 puede mejorar pasando por el nodo 2.
El camino de 1 → 2 tiene peso 2, y de 2 → 4 tiene peso 4, lo que da una distancia total de 2 + 4 = 6.
Este nuevo camino tiene una distancia mayor que la distancia directa de 5, por lo que no actualizamos.
Iteración 3: Usando el nodo 3 como intermediario
No hay ningún camino que pase por el nodo 3 y conecte a 1 con 4.*/
