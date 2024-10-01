package clase6;

import java.util.Arrays;
import java.util.Comparator;

class Proyecto {
    int costo;
    int beneficio;

    Proyecto(int costo, int beneficio) {
        this.costo = costo;
        this.beneficio = beneficio;
    }

    double getRatio() {
        return (double) beneficio / costo;
    }
}

public class actividad63greedy {
    public static void main(String[] args) {
        Proyecto[] proyectos = {
            new Proyecto(10, 100),
            new Proyecto(15, 200),
            new Proyecto(20, 150),
            new Proyecto(25, 300)
        };
        int presupuesto = 40;

        Arrays.sort(proyectos, Comparator.comparingDouble(Proyecto::getRatio).reversed());
        
        int beneficioTotal = 0;
        for (Proyecto proyecto : proyectos) {
            if (presupuesto >= proyecto.costo) {
                presupuesto -= proyecto.costo;
                beneficioTotal += proyecto.beneficio;
            }
        }
        
        System.out.println("Beneficio máximo: " + beneficioTotal);
    }
}

// COMPLEJIDAD ----> O(n log n)