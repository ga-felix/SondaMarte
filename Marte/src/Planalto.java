import java.util.Map;
import java.util.HashMap;
import java.lang.Boolean;

public class Planalto implements Terreno {

    private Map<Vetor2D, Boolean> area;
    private int linhas;
    private int colunas;

    public Planalto(Vetor2D maximo) {
        this.area = new HashMap<Vetor2D, Boolean>();
        this.linhas = maximo.obterX() + 1;
        this.colunas = maximo.obterY() + 1;
        for(int linha = 0; linha < linhas; linha++) {
            for(int coluna = 0; coluna < colunas; coluna++) {
                this.area.put(new Vetor2D(linha, coluna), Boolean.valueOf(false));
            }
        }
    }

    @Override
    public int obterLinhas() {
        return this.linhas;
    }

    @Override
    public int obterColunas() {
        return this.colunas;
    }

    @Override
    public void marcarPosicao(Vetor2D pos) {
        this.area.put(pos, Boolean.valueOf(true));
    }

    @Override
    public void desmarcarPosicao(Vetor2D pos) {
        this.area.put(pos, Boolean.valueOf(false));
    }

    @Override
    public boolean temObstaculo(Vetor2D pos) {
        return (this.area.get(pos).booleanValue());
    }
}
