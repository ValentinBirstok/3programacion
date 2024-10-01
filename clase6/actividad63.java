package clase6;

import java.util.ArrayList;
import java.util.List;

public class actividad63 {
    static int maxBeneficio = 0;
    static List<Integer> mejorSeleccion = new ArrayList<>();

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;
        
        seleccionarProyectos(costos, beneficios, presupuesto, 0, 0, new ArrayList<>());
        
        System.out.println("Beneficio máximo: " + maxBeneficio);
        System.out.println("Proyectos seleccionados: " + mejorSeleccion);
    }

    static void seleccionarProyectos(int[] costos, int[] beneficios, int presupuesto, int index, int beneficioActual, List<Integer> seleccion) {
        if (index >= costos.length) {
            if (beneficioActual > maxBeneficio) {
                maxBeneficio = beneficioActual;
                mejorSeleccion = new ArrayList<>(seleccion);
            }
            return;
        }
        
        // No seleccionar el proyecto actual
        seleccionarProyectos(costos, beneficios, presupuesto, index + 1, beneficioActual, seleccion);
        
        // Seleccionar el proyecto actual si el presupuesto lo permite
        if (costos[index] <= presupuesto) {
            seleccion.add(index);
            seleccionarProyectos(costos, beneficios, presupuesto - costos[index], index + 1, beneficioActual + beneficios[index], seleccion);
            seleccion.remove(seleccion.size() - 1);
        }
    }
}
//COMPLEJIDAD O(2 ^ n ).
