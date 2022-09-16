package chess;

import boardgame.Peca;
import boardgame.Position;
import boardgame.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Color color;

    public PecaXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean existePecaOponente(Position position){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(position);
        return p != null && p.getColor() != color;
    }
}
