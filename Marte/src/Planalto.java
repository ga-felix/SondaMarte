import java.util.Map;
import java.util.HashMap;
import java.lang.Boolean;

public class Planalto implements Terreno {

    private Map<int[], Boolean> area;
    private int linhas;
    private int colunas;

    public Planalto(int linhas, int colunas) {
        this.area = new HashMap<int[], Boolean>();
        this.linhas = linhas;
        this.colunas = colunas;
        for(int linha = 0; linha < linhas; linha++) {
            for(int coluna = 0; coluna < colunas; coluna++) {
                this.area.put(new int[]{linha, coluna}, Boolean.valueOf(false));
            }
        }
    }

    public int obterLinhas() {
        return this.linhas;
    }

    public int obterColunas() {
        return this.colunas;
    }

    public void marcarPosicao(int[] pos) {
        this.area.put(pos, Boolean.valueOf(true));
    }

    public void desmarcarPosicao(int[] pos) {
        this.area.put(pos, Boolean.valueOf(true));
    }

    public boolean temObstaculo(int[] pos) {
        return (this.area.get(pos).booleanValue());
    }
}
