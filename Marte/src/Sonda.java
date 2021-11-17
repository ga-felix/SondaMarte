import java.security.InvalidParameterException;

public class Sonda implements Rastreavel {

    private int[] posicao;
    private String direcaoCardinal;
    private Bussola bussola;

    public Sonda(int x, int y, String direcaoCardinal) {
        this.posicao = new int[]{x, y};
        this.direcaoCardinal = direcaoCardinal;
        this.bussola = new Bussola();
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

    public void acao(char sinal) throws InvalidParameterException {
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