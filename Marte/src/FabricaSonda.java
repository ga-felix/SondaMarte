public class FabricaSonda {

    public static Sonda criar(int x, int y, String direcaoCardinal) {
        Sonda sonda;
        try {
            sonda = new Sonda(x, y, direcaoCardinal);
        } catch(Exception e) {
            sonda = null;
        }
        return sonda;
    }

}