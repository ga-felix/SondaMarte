public class Planalto implements Terreno {

    private int[][] area;
    private int linhas;
    private int colunas;

    public Planalto(int linhas, int colunas) {
        this.area = new int[linhas][colunas]; 
        this.linhas = linhas;
        this.colunas = colunas;
    }

    public int obterLinhas() {
        return this.linhas;
    }

    public int obterColunas() {
        return this.colunas;
    }

    public int[][] obterTerreno() {
        return this.area;
    }
}
