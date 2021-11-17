import java.util.Arrays;
import java.util.Scanner;

// https://stackoverflow.com/questions/23506429/how-to-read-multiple-integer-values-from-a-single-line-of-input-in-java

public class App {
    public static void main(String[] args) throws Exception {
        Terreno terreno = new Planalto(3, 3); // Cuidado, ele passará a coordenada do ponto superior
        Explorador sonda = new Sonda(4, 2, "N"); // direito, não as dimensões do planalto!
        sonda.aterrissar(terreno);
        sonda.definirPosicao(2, 2);
        sonda.aterrissar(terreno);
        System.out.println("1 " + sonda.obterPosicaoAtual().obterX() + " " + sonda.obterPosicaoAtual().obterY());
        Explorador sonda2 = new Sonda(2, 2, "S");
        sonda2.aterrissar(terreno);
        System.out.println("2 " + sonda2.obterPosicaoAtual().obterX() + " " + sonda2.obterPosicaoAtual().obterY());
        /*Scanner scanner = new Scanner(System.in);
        String entrada;
        boolean terrenoNaoCriado = true;
        while(true) {
            if(terrenoNaoCriado) {
                terrenoNaoCriado = false;
            } else {
                scanner.next();
            }
        }*/
    }
}
