import java.util.HashMap;
import java.util.Map;

class Bussola {

    private Map<String, Vetor2D> vetoresDirecao;
    private Map<String, HashMap<String, String>> giroDirecao;

    private void adicionarDirecao(String direcao, Vetor2D pos, String direcaoEsquerda, String direcaoDireira) {
        this.vetoresDirecao.put(direcao, pos);
        HashMap<String, String> giros = new HashMap<String, String>();
        giros.put("L", direcaoEsquerda);
        giros.put("R", direcaoDireira);
        this.giroDirecao.put(direcao, giros);
    }

    protected Bussola() {
        this.vetoresDirecao = new HashMap<String, Vetor2D>();
        this.giroDirecao = new HashMap<String, HashMap<String, String>>();
        this.adicionarDirecao("N", new Vetor2D(0, 1), "W", "E");
        this.adicionarDirecao("S", new Vetor2D(0, -1), "E", "W");
        this.adicionarDirecao("E", new Vetor2D(1, 0), "N", "S");
        this.adicionarDirecao("W", new Vetor2D(-1, 0), "S", "N");
    }

    protected Vetor2D obterVetorDirecao(String direcao) {
        return this.vetoresDirecao.get(direcao);
    }

    protected String calcularDirecaoAposGiro(String direcaoAtual, String ladoDeGiro) {
        HashMap<String, String> giros = this.giroDirecao.get(direcaoAtual);
        return giros.get(ladoDeGiro);
    }

}