public interface Terreno {

    public int obterLinhas();

    public int obterColunas();

    public void marcarPosicao(Vetor2D pos);

    public void desmarcarPosicao(Vetor2D pos);

    public boolean temObstaculo(Vetor2D pos);
}
