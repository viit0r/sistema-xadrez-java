package chess.pecas;

import boardgame.Tabuleiro;
import chess.Color;
import chess.PecaXadrez;

public class Rei extends PecaXadrez {
    public Rei(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }

    @Override
    public String toString(){
        return "K";
    }
}
