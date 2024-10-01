package clase6;

import java.util.ArrayList;
import java.util.List;

public class actividad64bruta {
    static int maxGanancia = 0;
    static List<Integer> mejorSeleccion = new ArrayList<>();

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        seleccionarPaquetes(costos, ganancias, presupuesto, 0, 0, new ArrayList<>());

        System.out.println("Ganancia máxima: " + maxGanancia);
        System.out.println("Paquetes seleccionados: " + mejorSeleccion);
    }

    static void seleccionarPaquetes(int[] costos, int[] ganancias, int presupuesto, int index, int gananciaActual, List<Integer> seleccion) {
        if (index >= costos.length) {
            if (gananciaActual > maxGanancia) {
                maxGanancia = gananciaActual;
                mejorSeleccion = new ArrayList<>(seleccion);
            }
            return;
        }

        // No seleccionar el paquete actual
        seleccionarPaquetes(costos, ganancias, presupuesto, index + 1, gananciaActual, seleccion);

        // Seleccionar el paquete actual si el presupuesto lo permite
        if (costos[index] <= presupuesto) {
            seleccion.add(index);
            seleccionarPaquetes(costos, ganancias, presupuesto - costos[index], index + 1, gananciaActual + ganancias[index], seleccion);
            seleccion.remove(seleccion.size() - 1);
        }
    }
}
//COMPLEJIDAD O(2 ^ n ) donde n es el número de paquetes.