import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Terreno terreno = new Planalto(5, 5);
        Sonda sonda = new Sonda(0, 0, "N");
        Controlador controladorTeste = new Controlador(sonda, terreno);
        System.out.println(Arrays.toString(sonda.obterPosicaoAtual()));
        controladorTeste.receberAcao('M');
        System.out.println(Arrays.toString(sonda.obterPosicaoAtual()));
    }
}
