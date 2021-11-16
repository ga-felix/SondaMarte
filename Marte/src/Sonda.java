import java.util.HashMap;
import java.util.Map;

class Sonda implements ObjetoMovel {

    private int[] posicao;
    private Map<String, int[]> direcao;

    Sonda(int x, int y, String direcao) {
        this.posicao = new int[]{x, y};
        this.direcao = new HashMap<String, int[]>() {
            {
                put("N", new int[]{0, 1});
                put("S", new int[]{0, -1});
                put("E", new int[]{1, 0});
                put("W", new int[]{-1, 0});
            }
        };
    }

    public void mover() {

    }
}