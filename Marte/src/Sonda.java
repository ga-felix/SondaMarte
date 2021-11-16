class Sonda {

    private int[] posicao;
    private String pontoCardeal;
    private Bussola bussola;

    Sonda(int x, int y, String pontoCardeal) {
        this.posicao = new int[]{x, y};
        this.pontoCardeal = pontoCardeal;
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
        return this.pontoCardeal;
    }

    private void mudarPontoCardeal(String novoPonto) {
        this.pontoCardeal = novoPonto;
    }

    public void girarEsquerda() {

    }

    public void girarDireita() {
        
    }

    public void mover() {
        this.somarVetores2D(this.posicao, this.bussola.obterVetorDirecao(this.apontaPara()));
    }
}