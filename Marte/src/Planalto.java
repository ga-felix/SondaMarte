import java.util.List;
import java.util.ArrayList;

public class Planalto {

    private int[][] area;
    private List<Rastreavel> entidades;
    private int linhas;
    private int colunas;

    public Planalto(int linhas, int colunas) {
        this.area = new int[linhas][colunas]; 
        this.linhas = linhas;
        this.colunas = colunas;
        this.entidades = new ArrayList<Rastreavel>();
    }

    private boolean estaNoPlanalto(Rastreavel objeto) {
        int[] pos = objeto.posicaoAtual();
        return (pos[0] > 0 && pos[0] < this.linhas && pos[1] > 0 && pos[1] < this.colunas);
    }

    public void entrar(Rastreavel objeto) throws IndexOutOfBoundsException {
        if(this.estaNoPlanalto(objeto)) {
            this.entidades.add(objeto);
        }
        throw new IndexOutOfBoundsException("A sonda não conseguiu aterrisar no planalto.");
    }
}
