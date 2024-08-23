package clase1;
import java.math.BigInteger;
public class actividad2 {
    public static void main(String[] args) {
        long numerolong= 1233123232;
        long otronum=87654563;
        long resultado= numerolong=otronum;

        System.out.println("resultado del long: "+resultado);

        BigInteger numerobig=new BigInteger("4674827564765784657826478");
        BigInteger numerobigasumar=new BigInteger("457485247567824562785897");
        BigInteger sumaBigInteger= numerobig.add(numerobigasumar);
        System.out.println("resultado numeros big: "+sumaBigInteger);
    }
    
}
//el long se usa para usar números grandes pero dentro del rango de 64 bits.
//para operar en valores tipos long se usan los operadores aritméticos.
//mientras que el biginteger maneja números mas grandes del rango del long.
//para hacer la suma en el caso de big integer, al ser los números objetos, se usa el metodo add().
