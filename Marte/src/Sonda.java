import java.security.InvalidParameterException;

public class Sonda implements Explorador {

    private Posicao2D posicao;
    private String direcaoCardinal;
    private Bussola bussola;
    private Terreno terreno;

    public Sonda(int x, int y, String direcaoCardinal) {
        this.posicao = new Posicao2D(x, y);
        this.mudarDirecaoCardinal(direcaoCardinal);
        this.bussola = new Bussola();
        this.terreno = null;
    }

    public void definirPosicao(int x, int y) {
        this.posicao.definir(x, y);
    }

    private boolean consegueAterrissar(Terreno alvo) {
        Posicao2D pos = this.obterPosicaoAtual();
        int x = pos.obterX();
        int y = pos.obterY();
        return (x >= 0 && x < alvo.obterLinhas() && y >= 0 && y < alvo.obterColunas());
    }

    public void aterrissar(Terreno alvo) {
        Posicao2D pos = this.obterPosicaoAtual();
        if(this.consegueAterrissar(alvo) && !alvo.temObstaculo(pos)) {
            this.terreno = alvo;
            alvo.marcarPosicao(pos);
        }
        else {
            System.out.println("Aterrissagem da sonda falhou. Tente mudar as coordenadas de posicao.");
        }
    }

    public Posicao2D obterPosicaoAtual() {
        return this.posicao;
    }

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
        Posicao2D posFuturo = Posicao2D.somar(this.posicao, Posicao2D.lerVetor2D(this.bussola.obterVetorDirecao(this.obterDirecao())));
        if(!this.terreno.temObstaculo(posFuturo)) {
            this.terreno.desmarcarPosicao(this.posicao);
            this.posicao = posFuturo;
            this.terreno.marcarPosicao(this.posicao);
        } else {
            System.out.println("Obstáculo encontrado a frente. Não é possível mover a sonda.");
        }
    }

    public void acao(char sinal) throws InvalidParameterException {
        if(this.terreno == null) {
            System.out.println("A sonda não aterrissou ainda e portanto não pode receber sinais.");
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

}