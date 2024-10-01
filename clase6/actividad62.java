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
/*1. Ningún objeto
Peso total: 0
Valor total: 0
No excede la capacidad.
Valor total = 0
2. Solo el objeto 1
Peso total: 2
Valor total: 4
No excede la capacidad.
Valor total = 4
3. Solo el objeto 2
Peso total: 5
Valor total: 2
No excede la capacidad.
Valor total = 2
4. Solo el objeto 3
Peso total: 6
Valor total: 1
No excede la capacidad.
Valor total = 1
5. Solo el objeto 4
Peso total: 7
Valor total: 6
No excede la capacidad.
Valor total = 6
6. Objetos 1 y 2
Peso total: 2 + 5 = 7
Valor total: 4 + 2 = 6
No excede la capacidad.
Valor total = 6
7. Objetos 1 y 3
Peso total: 2 + 6 = 8
Valor total: 4 + 1 = 5
No excede la capacidad.
Valor total = 5
8. Objetos 1 y 4
Peso total: 2 + 7 = 9
Valor total: 4 + 6 = 10
No excede la capacidad.
Valor total = 10 (Máximo valor encontrado hasta ahora)
9. Objetos 2 y 3
Peso total: 5 + 6 = 11
Excede la capacidad.
Esta combinación no es válida.
10. Objetos 2 y 4
Peso total: 5 + 7 = 12
Excede la capacidad.
Esta combinación no es válida.
11. Objetos 3 y 4
Peso total: 6 + 7 = 13
Excede la capacidad.
Esta combinación no es válida.
12. Objetos 1, 2 y 3
Peso total: 2 + 5 + 6 = 13
Excede la capacidad.
Esta combinación no es válida.
13. Objetos 1, 2 y 4
Peso total: 2 + 5 + 7 = 14
Excede la capacidad.
Esta combinación no es válida.
14. Objetos 1, 3 y 4
Peso total: 2 + 6 + 7 = 15
Excede la capacidad.
Esta combinación no es válida.
15. Objetos 2, 3 y 4
Peso total: 5 + 6 + 7 = 18
Excede la capacidad.
Esta combinación no es válida.
16. Todos los objetos (1, 2, 3 y 4)
Peso total: 2 + 5 + 6 + 7 = 20
Excede la capacidad.
Esta combinación no es válida*/
        
        