import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Olá, mundo!");
        Sonda sondaTeste = new Sonda(0, 0, "N");
        System.out.println("Posição atual: " + Arrays.toString(sondaTeste.posicaoAtual()));
        sondaTeste.lerSinal('M');
        System.out.println("Nova posição: " + Arrays.toString(sondaTeste.posicaoAtual()));
        sondaTeste.lerSinal('L');
        System.out.println("Nova direção cardinal: " + sondaTeste.apontaPara());
        sondaTeste.lerSinal('L');
        System.out.println("Nova direção cardinal: " + sondaTeste.apontaPara());
        sondaTeste.lerSinal('M');
        System.out.println("Nova posição: " + Arrays.toString(sondaTeste.posicaoAtual()));
    }
}
