public interface Terreno {

    public int obterLinhas();

    public int obterColunas();

    public void marcarPosicao(Posicao2D pos);

    public void desmarcarPosicao(Posicao2D pos);

    public boolean temObstaculo(Posicao2D pos);
}
