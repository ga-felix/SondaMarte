import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Console leitor = new Console();
        Terreno planalto = new Planalto(leitor.lerDadosTerreno());
        ArrayList<Sonda> sondas = new ArrayList<Sonda>();
        while(true) {
            sondas.add(leitor.lerDadosSonda(planalto));
            Sonda sonda = sondas.get(sondas.size() - 1);
            leitor.executarComandos(sonda);
            System.out.println(sonda);
        }
    }
}
