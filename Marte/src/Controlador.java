public class Controlador {

    private Rastreavel entidade;
    private Terreno terreno;
    private boolean entrou;

    private boolean estaNoTerreno() {
        int[] pos = this.entidade.obterPosicaoAtual();
        return (pos[0] >= 0 && pos[0] < this.terreno.obterLinhas() && pos[1] >= 0 && pos[1] < this.terreno.obterColunas());
    }

    public void tentarEntrada(int[] pos) {
        this.entrou = (this.estaNoTerreno() && !this.terreno.temObstaculo(pos[0], pos[1]));
    }

    public Controlador(Rastreavel entidade, Terreno alvo) {
        this.entidade = entidade;
        this.terreno = alvo;
        this.tentarEntrada(this.entidade.obterPosicaoAtual());
    }

    public void receberAcao(char acao) {
        if(entrou) entidade.acao(acao);
        else System.out.println("A sonda não conseguiu aterrissar ainda. Tente novamente.");
    }


}