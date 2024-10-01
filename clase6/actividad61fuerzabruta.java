package clase6;

public class actividad61fuerzabruta {
    public static void main(String[] args) {
        int[] costos = {3, 4, 2}; // Costo de los jugadores
        int[] valores = {4, 5, 3}; // Valor de los jugadores
        int capacidad = 6; // Presupuesto máximo
        int n = valores.length;

        int mejorValor = 0; // Mejor valor encontrado
        String mejorCombinacion = ""; // Combinación que da el mejor valor
    
         // Evaluar todas las combinaciones de jugadores
         for (int i = 0; i < (1 << n); i++) { // 2^n combinaciones
            int costoTotal = 0;
            int valorTotal = 0;
            String combinacion = "Comprar: ";

            for (int j = 0; j < n; j++) {
                // Verificar si el jugador j está incluido en la combinación
                if ((i & (1 << j)) > 0) {
                    costoTotal += costos[j];
                    valorTotal += valores[j];
                    combinacion += "Jugador " + (j + 1) + ", "; // Concatenar cadena
                }
            }
                        // Comprobar si la combinación es válida
                        if (costoTotal <= capacidad) {
                            if (valorTotal > mejorValor) {
                                mejorValor = valorTotal;
                                mejorCombinacion = combinacion;
                            }
                        }
                    }
            
                    // Mostrar resultados
                    System.out.println("Valor máximo: " + mejorValor);
                    System.out.println("Combinación óptima: " + mejorCombinacion);
                }
            }
        
    
    //PRUEBA DE ESCRITORIO
    //Jugador 1: Con costo 3 y rendimiento 4:

    //Si el presupuesto es menor a 3, no podemos incluirlo, así que dp[1][j] = 0.
    //A partir de un presupuesto de 3, podemos incluir al jugador y el rendimiento es 4.
    //Jugador 2: Con costo 4 y rendimiento 5:

    //Para un presupuesto de 4, el mejor rendimiento es 5 (fichamos al jugador 2).
    //Para presupuestos mayores, decidimos si fichamos al jugador 2 junto al 1 o solo al 1. Para un presupuesto de 6, podemos fichar al jugador 2 junto al 1 (rendimiento total 9).
    //Jugador 3: Con costo 2 y rendimiento 3:

    //Para un presupuesto de 2, fichamos al jugador 3 y obtenemos 3.
    //Para presupuestos mayores, si fichamos al jugador 1 y al jugador 3, obtenemos 7 (costo total 5).
    //Para un presupuesto de 6, si fichamos a los jugadores 2 y 3, obtenemos un rendimiento total de 8 (costo total 6).
    //Paso 3: Resultado
    //El rendimiento máximo con un presupuesto de 6 es 8, seleccionando a los jugadores 2 y 3 (costo total: 6).

    
        //Combinación 000: No seleccionamos a nadie

        //Rendimiento: 0
        //Costo: 0
        //Combinación 001: Solo seleccionamos el Objeto 3

        //Rendimiento: 3
        //Costo: 2
        //Combinación 010: Solo seleccionamos el Objeto 2

        //Rendimiento: 5
        //Costo: 4
        //Combinación 011: Objetos 2 y 3

        //Rendimiento: 5 + 3 = 8
        //Costo: 4 + 2 = 6 (mejor)
        //Combinación 100: Solo seleccionamos el Objeto 1

        //Rendimiento: 4
        //Costo: 3
        //Combinación 101: Objetos 1 y 3

        //Rendimiento: 4 + 3 = 7
        //Costo: 3 + 2 = 5
        //Combinación 110: Objetos 1 y 2

        //Rendimiento: 4 + 5 = 9
        //Costo: 3 + 4 = 7 (excede el presupuesto)
        //Combinación 111: Objetos 1, 2 y 3

        //Rendimiento: 4 + 5 + 3 = 12
        //Costo: 3 + 4 + 2 = 9 (excede el presupuesto)