import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class Posicao2D {
    
    private List<Integer> posicao;

    public int obterX() {
        return this.posicao.get(0).intValue();
    }

    public int obterY() {
        return this.posicao.get(1).intValue();
    }

    public void definir(int x, int y) {
        this.posicao.set(0, Integer.valueOf(x));
        this.posicao.set(1, Integer.valueOf(y));
    }   

    public Posicao2D(int x, int y) {
        this.posicao = new ArrayList<Integer>(2);
        this.posicao.add(0, Integer.valueOf(x));
        this.posicao.add(1, Integer.valueOf(y));
    }

}
