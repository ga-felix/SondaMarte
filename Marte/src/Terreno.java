public interface Terreno {

    public int obterLinhas();

    public int obterColunas();

    public void marcarPosicao(int[] pos);

    public void desmarcarPosicao(int[] pos);

    public boolean temObstaculo(int[] pos);
}
