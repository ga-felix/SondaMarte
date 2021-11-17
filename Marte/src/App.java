import java.util.Arrays;
import java.util.Scanner;

// https://stackoverflow.com/questions/23506429/how-to-read-multiple-integer-values-from-a-single-line-of-input-in-java

public class App {
    public static void main(String[] args) throws Exception {
        Terreno terreno;
        Sonda sonda;
        Scanner scanner = new Scanner(System.in);
        String entrada;
        boolean terrenoNaoCriado = true;
        while(true) {
            if(terrenoNaoCriado) {
                terrenoNaoCriado = false;
            } else {
                scanner.next();
            }
        }
    }
}
