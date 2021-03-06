import java.security.InvalidParameterException;

public class Sonda implements Explorador {

    private Vetor2D posicao;
    private String direcaoCardinal;
    private Bussola bussola;
    private Terreno terreno;

    public Sonda(Vetor2D posicao, String direcaoCardinal) {
        this.posicao = posicao;
        this.mudarDirecaoCardinal(direcaoCardinal);
        this.bussola = new Bussola();
        this.terreno = null;
    }

    public boolean aterrissou() {
        return(this.terreno != null);
    }

    @Override
    public void definirPosicao(int x, int y) {
        if(terreno != null) return;
        this.posicao.definir(x, y);
    }

    private boolean consegueAterrissar(Terreno alvo) {
        Vetor2D pos = this.obterPosicaoAtual();
        int x = pos.obterX();
        int y = pos.obterY();
        return (x >= 0 && x < alvo.obterLinhas() && y >= 0 && y < alvo.obterColunas());
    }

    @Override
    public void aterrissar(Terreno alvo) {
        Vetor2D pos = this.obterPosicaoAtual();
        if(this.consegueAterrissar(alvo) && !alvo.temObstaculo(pos)) {
            this.terreno = alvo;
            alvo.marcarPosicao(pos);
            System.out.println("Aterrissagem foi um sucesso!");
        }
        else {
            System.out.println("Aterrissagem da sonda falhou. Tente mudar as coordenadas de posicao.");
        }
    }

    @Override
    public Vetor2D obterPosicaoAtual() {
        return this.posicao;
    }

    @Override
    public String obterDirecao() {
        return this.direcaoCardinal;
    }

    private void mudarDirecaoCardinal(String novaDirecao) {
        this.direcaoCardinal = novaDirecao;
    }

    private void girarEsquerda() {
        this.mudarDirecaoCardinal(this.bussola.calcularDirecaoAposGiro(this.obterDirecao(), "L"));
    }

    private void girarDireita() {
        this.mudarDirecaoCardinal(this.bussola.calcularDirecaoAposGiro(this.obterDirecao(), "R"));
    }

    private void mover() {
        Vetor2D posFuturo = Vetor2D.somar(this.posicao, this.bussola.obterVetorDirecao(this.obterDirecao()));
        try {
            if(!this.terreno.temObstaculo(posFuturo)) {
                this.terreno.desmarcarPosicao(this.posicao);
                this.posicao = posFuturo;
                this.terreno.marcarPosicao(this.posicao);
            } else {
                System.out.println("Obst??culo encontrado a frente. N??o ?? poss??vel mover a sonda.");
            }
        } catch(NullPointerException exception) {
            System.out.println("N??o ?? poss??vel mover. Verifique se o movimento est?? dentro do terreno.");
        }
    }

    @Override
    public void acao(char sinal) throws InvalidParameterException {
        if(this.terreno == null) {
            System.out.println("A sonda n??o aterrissou ainda e portanto n??o pode receber sinais.");
            return;
        }
        switch(sinal) {
            case 'L':
                this.girarEsquerda();
                break;
            case 'R':
                this.girarDireita();
                break;
            case 'M':
                this.mover();
                break;
            default:
                throw new InvalidParameterException("A sonda recebeu um sinal desconhecido.");
        }
    }

    @Override
    public String toString() {
        return "(Posicao: " + this.obterPosicaoAtual() + "), (Direcao: " + this.obterDirecao() + ")";
    }

}