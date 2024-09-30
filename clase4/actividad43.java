package clase4;
public class Actividad43 {

    public static void main(String[] args) {
        int[] valores = {30, 50, 60};
        int[] pesos = {10, 20, 30};
        int capacidadMochila = 50;

        double maxValue = FractionalKnapsack(valores.length, valores, pesos, capacidadMochila);
        System.out.println("Valor total máximo que se puede cargar: " + maxValue);
    }

    static double FractionalKnapsack(int n, int[] v, int[] w, int W) {
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) v[i] / w[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ratio[j] < ratio[j + 1]) {
                    double tempRatio = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tempRatio;

                    int tempValor = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tempValor;

                    int tempPeso = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = tempPeso;
                }
            }
        }

        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (W == 0) {
                break;
            }
            if (w[i] <= W) {
                maxValue += v[i];
                W -= w[i];
            } else {
                maxValue += (v[i] * ((double) W / w[i]));
                W = 0;
            }
        }
        return maxValue;
    }
}