public interface Explorador {

    public Vetor2D obterPosicaoAtual();

    public String obterDirecao();

    public void acao(char acao);

    public void aterrissar(Terreno terreno);

    public void definirPosicao(int x, int y);

}
