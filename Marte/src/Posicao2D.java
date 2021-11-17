public class Posicao2D {
    
    private int x;
    private int y;

    public int obterX() {
        return this.x;
    }

    public int obterY() {
        return this.y;
    }

    public void definir(int x, int y) {
        this.x = x;
        this.y = y;
    }   

    public Posicao2D(int x, int y) {
        this.definir(x, y);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Posicao2D))
            return false;
        Posicao2D outro = (Posicao2D) obj;
        return (this.obterX() == outro.obterX() && this.obterY() == outro.obterY());
    }

    public final int hashCode() {
        return this.obterX() + this.obterY();
    }

    public String toString() {
        return String.format("(" + this.obterX() + ":" + this.obterY() + ")");
    }

    public static Posicao2D lerVetor2D(int[] pos) {
        if(pos.length != 2) return null;
        return new Posicao2D(pos[0], pos[1]);
    }

    public static Posicao2D somar(Posicao2D a, Posicao2D b) {
        return new Posicao2D(a.obterX() + b.obterX(), a.obterY() + b.obterY());
    }
        

}
