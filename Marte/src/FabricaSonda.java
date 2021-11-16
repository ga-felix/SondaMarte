public class FabricaSonda {

    public static Sonda criar(int x, int y, String direcaoCardinal, Terreno alvo) {
        Sonda sonda;
        try {
            sonda = new Sonda(x, y, direcaoCardinal, alvo);
        } catch(Exception e) {
            System.out.println(e);
            sonda = null;
        }
        return sonda;
    }

}