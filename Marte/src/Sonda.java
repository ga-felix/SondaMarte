import java.security.InvalidParameterException;

public class Sonda implements Rastreavel {

    private int[] posicao;
    private String direcaoCardinal;
    private Bussola bussola;
    private Terreno terreno;

    private boolean aterrissou(Terreno alvo) {
        int[] pos = this.obterPosicaoAtual();
        return (pos[0] > 0 && pos[0] < alvo.obterLinhas() && pos[1] > 0 && pos[1] < alvo.obterColunas());
    }

    private Terreno tentarAterrissagem(Terreno alvo) throws IndexOutOfBoundsException {
        if(this.aterrissou(alvo)) {
            return alvo;
        }
        throw new IndexOutOfBoundsException("A sonda não conseguiu aterrisar no planalto.");
    }

    public Sonda(int x, int y, String direcaoCardinal, Terreno alvo) {
        this.posicao = new int[]{x, y};
        this.direcaoCardinal = direcaoCardinal;
        this.bussola = new Bussola();
        this.terreno = this.tentarAterrissagem(alvo);
    }

    public int[] obterPosicaoAtual() {
        return this.posicao;
    }

    public String obterDirecao() {
        return this.direcaoCardinal;
    }

    private void mudarDirecaoCardinal(String novaDirecao) {
        this.direcaoCardinal = novaDirecao;
    }

    private void girarEsquerda() {
        this.mudarDirecaoCardinal(this.bussola.calcularDirecaoAposGiro(this.obterDirecao(), "L"));
    }

    private void girarDireita() {
        this.mudarDirecaoCardinal(this.bussola.calcularDirecaoAposGiro(this.obterDirecao(), "R"));
    }

    private void somarVetores2D(int[] vetorA, int[] vetorB) {
        vetorA[0] += vetorB[0];
        vetorA[1] += vetorB[1];
    }

    private void mover() {
        this.somarVetores2D(this.posicao, this.bussola.obterVetorDirecao(this.obterDirecao()));
    }

    public void lerSinal(char sinal) throws InvalidParameterException {
        switch(sinal) {
            case 'L':
                this.girarEsquerda();
                break;
            case 'R':
                this.girarDireita();
                break;
            case 'M':
                this.mover();
                break;
            default:
                throw new InvalidParameterException("A sonda recebeu um sinal desconhecido.");
        }
    }

}