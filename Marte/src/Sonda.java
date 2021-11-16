public class Sonda implements Rastreavel {

    private int[] posicao;
    private String direcaoCardinal;
    private Bussola bussola;

    Sonda(int x, int y, String direcaoCardinal) {
        this.posicao = new int[]{x, y};
        this.direcaoCardinal = direcaoCardinal;
        this.bussola = new Bussola();
    }

    private void somarVetores2D(int[] vetorA, int[] vetorB) {
        vetorA[0] += vetorB[0];
        vetorA[1] += vetorB[1];
    }

    public int[] posicaoAtual() {
        return this.posicao;
    }

    public String apontaPara() {
        return this.direcaoCardinal;
    }

    private void mudardirecaoCardinal(String novaDirecao) {
        this.direcaoCardinal = novaDirecao;
    }

    private void girarEsquerda() {
        this.mudardirecaoCardinal(this.bussola.calcularGiro(this.apontaPara(), "L"));
    }

    private void girarDireita() {
        this.mudardirecaoCardinal(this.bussola.calcularGiro(this.apontaPara(), "R"));
    }

    private void mover() {
        this.somarVetores2D(this.posicao, this.bussola.obterVetorDirecao(this.apontaPara()));
    }

    public void lerSinal(char sinal) {
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
        }
    }
}