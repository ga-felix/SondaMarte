public interface Terreno {

    public int[][] obterTerreno();

    public int obterLinhas();

    public int obterColunas();

    public void marcarPosicao(int x, int y);

    public void desmarcarPosicao(int x, int y);

    public boolean temObstaculo(int x, int y);
}
