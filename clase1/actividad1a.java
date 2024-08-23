package clase1;

public class actividad1a {
    public static void main(String[] args) {

        int[] array = {1,98,12,3,67,54}; //1
        int maxi = 0; //1

        for (int i=0;i<array.length;i++) { //1+2(n+1)+n
            if  (array[i] > maxi) { //2n
                maxi = array[i]; //n
            }
        }

        System.out.println(maxi); //1
        //listo

        //f(n)= 1+1+1+2(n+1)+n+2n+n+1
        //f(n)= 4+2n+2+4n
        //f(n)= 6n+6
    }
}