package clase3;

public class actividad31 {
    public static void main(String[] args) {
        int[] idclientes={143,223,437,843,165};
        String[] nombreclientes={"juan","martin","alberto","jose","matias"};
        int[] scoringclientes={10,8,13,4,9};
        int scoremaximo=scoremaximo(scoringclientes);
        System.out.println(scoremaximo);

        for(int i=0;i<scoringclientes.length;i++){
            if (scoremaximo==scoringclientes[i]){
                System.out.println("El score maximo es "+scoremaximo+" de "+nombreclientes[i]+" cuyo id es "+idclientes[i]);
            }
        }
    }
    private static int scoremaximo(int[] scoringclientes){
        return busqmaximo(scoringclientes,0,scoringclientes.length-1);

    }
    private static int busqmaximo(int[] scoringclientes, int i, int cantidad) {
        if (i == cantidad) {
            return scoringclientes[i];  // Devuelve el elemento cuando es el único
        }
        int mitad = (cantidad + i) / 2;
        int izq = busqmaximo(scoringclientes, i, mitad);
        int der = busqmaximo(scoringclientes, mitad + 1, cantidad);  // Ajusta el índice para la mitad derecha
        return Math.max(izq, der);  // Devuelve el máximo de los dos
    
    }
    

}
