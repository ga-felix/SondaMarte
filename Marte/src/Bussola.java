import java.util.HashMap;
import java.util.Map;

class Bussola {

    private Map<String, int[]> direcao;

    private void adicionarDirecao(String chave, int[] vetor) {
        this.direcao.put(chave, vetor);
    }

    Bussola() {
        this.direcao = new HashMap<String, int[]>();
        this.adicionarDirecao("N", new int[]{0, 1});
        this.adicionarDirecao("S", new int[]{0, -1});
        this.adicionarDirecao("E", new int[]{1, 0});
        this.adicionarDirecao("W", new int[]{-1, 0});
    }

    public int[] obterVetorDirecao(String chave) {
        return this.direcao.get(chave);
    }

}