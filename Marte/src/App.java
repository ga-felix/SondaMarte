import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Terreno terreno = new Planalto(5, 5);
        Sonda sondaTeste = FabricaSonda.criar(0, 0, "N");
        System.out.println("Posição atual: " + Arrays.toString(sondaTeste.obterPosicaoAtual()));
        sondaTeste.lerSinal('M');
        System.out.println("Nova posição: " + Arrays.toString(sondaTeste.obterPosicaoAtual()));
        sondaTeste.lerSinal('L');
        System.out.println("Nova direção cardinal: " + sondaTeste.obterDirecao());
        sondaTeste.lerSinal('L');
        System.out.println("Nova direção cardinal: " + sondaTeste.obterDirecao());
        sondaTeste.lerSinal('M');
        System.out.println("Nova posição: " + Arrays.toString(sondaTeste.obterPosicaoAtual()));
    }
}
