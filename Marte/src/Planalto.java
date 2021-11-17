import java.util.Map;
import java.util.HashMap;
import java.lang.Boolean;

public class Planalto implements Terreno {

    private Map<Posicao2D, Boolean> area;
    private int linhas;
    private int colunas;

    public Planalto(int xMaximo, int yMaximo) {
        this.area = new HashMap<Posicao2D, Boolean>();
        this.linhas = xMaximo + 1;
        this.colunas = yMaximo + 1;
        for(int linha = 0; linha < linhas; linha++) {
            for(int coluna = 0; coluna < colunas; coluna++) {
                this.area.put(new Posicao2D(linha, coluna), Boolean.valueOf(false));
            }
        }
    }

    public int obterLinhas() {
        return this.linhas;
    }

    public int obterColunas() {
        return this.colunas;
    }

    public void marcarPosicao(Posicao2D pos) {
        this.area.put(pos, Boolean.valueOf(true));
    }

    public void desmarcarPosicao(Posicao2D pos) {
        this.area.put(pos, Boolean.valueOf(false));
    }

    public boolean temObstaculo(Posicao2D pos) {
        return (this.area.get(pos).booleanValue());
    }
}
