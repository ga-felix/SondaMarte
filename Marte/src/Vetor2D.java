public class Vetor2D {
    
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

    public Vetor2D(int x, int y) {
        this.definir(x, y);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Vetor2D))
            return false;
        Vetor2D outro = (Vetor2D) obj;
        return (this.obterX() == outro.obterX() && this.obterY() == outro.obterY());
    }

    public final int hashCode() {
        return this.obterX() + this.obterY();
    }

    public String toString() {
        return String.format("(" + this.obterX() + ":" + this.obterY() + ")");
    }

    public static Vetor2D somar(Vetor2D a, Vetor2D b) {
        return new Vetor2D(a.obterX() + b.obterX(), a.obterY() + b.obterY());
    }
        

}
