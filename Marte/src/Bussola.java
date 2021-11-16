import java.util.HashMap;
import java.util.Map;

public class Bussola {

    private Map<String, int[]> direcao;
    private Map<String, HashMap<String, String>> giros;

    private void adicionarDirecao(String direcao, int[] vetor, String transicaoEsq, String transicaoDir) {
        this.direcao.put(direcao, vetor);
        HashMap<String, String> transicoes = new HashMap<String, String>();
        transicoes.put("L", transicaoEsq);
        transicoes.put("R", transicaoDir);
        this.giros.put(direcao, transicoes);
    }

    public Bussola() {
        this.direcao = new HashMap<String, int[]>();
        this.giros = new HashMap<String, HashMap<String, String>>();
        this.adicionarDirecao("N", new int[]{0, 1}, "W", "E");
        this.adicionarDirecao("S", new int[]{0, -1}, "E", "W");
        this.adicionarDirecao("E", new int[]{1, 0}, "N", "S");
        this.adicionarDirecao("W", new int[]{-1, 0}, "S", "N");
    }

    public int[] obterVetorDirecao(String direcao) {
        return this.direcao.get(direcao);
    }

    public String calcularGiro(String direcaoAtual, String giro) {
        HashMap<String, String> transicoes = this.giros.get(direcaoAtual);
        return transicoes.get(giro);
    }

}