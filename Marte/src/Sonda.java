import java.security.InvalidParameterException;

public class Sonda implements Rastreavel {

    private int[] posicao;
    private String direcaoCardinal;
    private Bussola bussola;
    private boolean aterrisou;
    private Terreno terreno;

    public Sonda(int x, int y, String direcaoCardinal) {
        this.posicao = new int[]{x, y};
        this.direcaoCardinal = direcaoCardinal;
        this.bussola = new Bussola();
        this.aterrisou = false;
    }

    public void mudarPosicaoAterrissagem(int x, int y) {
        this.posicao = new int[]{x, y};
    }

    private boolean consegueAterrissar(Terreno alvo) {
        int[] pos = this.obterPosicaoAtual();
        return (pos[0] >= 0 && pos[0] < alvo.obterLinhas() && pos[1] >= 0 && pos[1] < alvo.obterColunas());
    }

    public void aterrissar(Terreno alvo) {
        int[] pos = this.obterPosicaoAtual();
        if(this.consegueAterrissar(alvo) && !alvo.temObstaculo(pos)) {
            this.aterrisou = true;
        }
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

    private int[] somarVetores2D(int[] vetorA, int[] vetorB) {
        return new int[]{vetorA[0] + vetorB[0], vetorA[1] + vetorB[1]};
    }

    private void mover() {
        if(!this.aterrisou) return;
        int[] posFuturo = this.somarVetores2D(this.posicao, this.bussola.obterVetorDirecao(this.obterDirecao()));
        if(!this.terreno.temObstaculo(posFuturo)) {
            this.posicao = posFuturo;
        } else {
            System.out.println("Obstáculo encontrado a frente. Não é possível mover a sonda.");
        }
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