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

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Posicao2D))
            return false;
        Posicao2D other = (Posicao2D) o;
        return (this.obterX() == other.obterX() && this.obterY() == other.obterY());
    }

}
