public class Controlador {

    private Rastreavel entidade;
    private Terreno terreno;
    private boolean entrou;

    private boolean estaNoTerreno() {
        int[] pos = this.entidade.obterPosicaoAtual();
        return (pos[0] >= 0 && pos[0] < this.terreno.obterLinhas() && pos[1] >= 0 && pos[1] < this.terreno.obterColunas());
    }

    private boolean tentarEntrada() {
        int[] pos = this.entidade.obterPosicaoAtual();
        return (this.estaNoTerreno() && !this.terreno.temObstaculo(pos[0], pos[1]));
    }

    public Controlador(Rastreavel entidade, Terreno alvo) {
        this.entidade = entidade;
        this.terreno = alvo;
        this.entrou = this.tentarEntrada();
    }


}