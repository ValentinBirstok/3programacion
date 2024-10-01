package clase6;
import java.util.Arrays;
import java.util.Comparator;


class Paquete {
    int costo;
    int ganancia;

    Paquete(int costo, int ganancia) {
        this.costo = costo;
        this.ganancia = ganancia;
    }

    double getRatio() {
        return (double) ganancia / costo;
    }
}

public class actividad64greedy {
    public static void main(String[] args) {
        Paquete[] paquetes = {
            new Paquete(12, 150),
            new Paquete(20, 200),
            new Paquete(15, 100),
            new Paquete(25, 300)
        };
        int presupuesto = 35;

        Arrays.sort(paquetes, Comparator.comparingDouble(Paquete::getRatio).reversed());

        int gananciaTotal = 0;
        for (Paquete paquete : paquetes) {
            if (presupuesto >= paquete.costo) {
                presupuesto -= paquete.costo;
                gananciaTotal += paquete.ganancia;
            }
        }

        System.out.println("Ganancia máxima: " + gananciaTotal);
    }
    //complejidad --> O(n log n)
}