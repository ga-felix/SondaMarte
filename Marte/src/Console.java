import java.util.Scanner;
import java.lang.Integer;

public class Console {
    
    private Scanner scanner;

    private Console() {
        this.scanner = new Scanner(System.in);
    }

    private Vetor2D lerDimensoes2D() {
        String[] dimensoes = scanner.nextLine().trim().split("\\s+");
        if(dimensoes.length != 2) return null;
        int[] pos = new int[2];
        for (int indice = 0; indice < pos.length; indice++) {
            pos[indice] = Integer.parseInt(dimensoes[indice]);
        }
        return new Vetor2D(pos[0], pos[1]);
    }

    public static void abrirLeitura() {
        Console leitor = new Console();

    }

}
