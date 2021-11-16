import java.util.HashMap;
import java.util.Map;

class Sonda implements ObjetoMovel {

    private int[] posicao;
    private String pontoCardeal;
    private Map<String, int[]> direcao;

    Sonda(int x, int y, String pontoCardeal) {
        this.posicao = new int[]{x, y};
        this.pontoCardeal = pontoCardeal;
        this.direcao = new HashMap<String, int[]>();
        this.direcao.put("N", new int[]{0, 1});
        this.direcao.put("S", new int[]{0, -1});
        this.direcao.put("E", new int[]{1, 0});
        this.direcao.put("W", new int[]{-1, 0});
    }

    private void somarVetores2D(int[] vetorA, int[] vetorB) {
        vetorA[0] += vetorB[0];
        vetorA[1] += vetorB[1];
    }

    public int[] posicaoAtual() {
        return this.posicao;
    }

    public String apontaPara() {
        return this.pontoCardeal;
    }

    public void mover() {
        this.somarVetores2D(this.posicao, this.direcao.get(this.apontaPara()));
    }
}