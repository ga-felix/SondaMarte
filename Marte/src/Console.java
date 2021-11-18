import java.util.Scanner;
import java.lang.Integer;

public class Console {
    
    private Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public Vetor2D lerTerreno() {
        String[] dimensoes = scanner.nextLine().trim().split("\\s+");
        if(dimensoes.length != 2) return null;
        int[] pos = new int[2];
        for (int indice = 0; indice < pos.length; indice++) {
            pos[indice] = Integer.parseInt(dimensoes[indice]);
        }
        return new Vetor2D(pos[0], pos[1]);
    }

    public Vetor2D lerDadosTerreno() {
        Vetor2D dimensoes = null;
        do {
            dimensoes = this.lerTerreno();
        } while(dimensoes == null);
        return dimensoes;
    }

    public Sonda lerSonda() {
        String[] dados = scanner.nextLine().trim().split("\\s+");
        if(dados.length != 3) return null;
        int[] pos = new int[2];
        for (int indice = 0; indice < pos.length; indice++) {
            pos[indice] = Integer.parseInt(dados[indice]);
        }
        return new Sonda(new Vetor2D(pos[0], pos[1]), dados[dados.length - 1]);
    }

    public Sonda lerDadosSonda(Terreno terreno) {
        Sonda sonda = null;
        do {
            sonda = this.lerSonda();
            sonda.aterrissar(terreno);
        } while(!sonda.aterrissou());
        return sonda;
    }

    public void executarComandos(Explorador explorador) {
        char[] comandos = scanner.nextLine().toCharArray();
        for(char c: comandos) {
            explorador.acao(c);
        }
    }

}
