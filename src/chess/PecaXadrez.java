package chess;

import boardgame.Peca;
import boardgame.Position;
import boardgame.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Color color;
    private int contadorMovimentos;

    public PecaXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getContadorMovimentos(){
        return contadorMovimentos;
    }
    protected void acrescentaMovimento(){
        contadorMovimentos++;
    }
    protected void tirarMovimento(){
        contadorMovimentos--;
    }
    public XadrezPosition getXadrezPosition(){
        return XadrezPosition.fromPosition(position);
    }
    protected boolean existePecaOponente(Position position){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(position);
        return p != null && p.getColor() != color;
    }
}
