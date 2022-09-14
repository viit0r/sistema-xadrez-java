package chess.pecas;

import boardgame.Tabuleiro;
import chess.Color;
import chess.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }
    @Override
    public String toString(){
        return "T";
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        return mat;
    }
}
