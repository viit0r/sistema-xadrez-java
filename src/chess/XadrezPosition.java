package chess;

import boardgame.Position;

public class XadrezPosition {
    private char coluna;
    private int linha;

    public XadrezPosition(char coluna, int linha) {
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new XadrezException("Erro ao instanciar XadrezPosition. Os valores válidos são de a1 a h8.");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    protected Position toPosition(){
        return new Position(8 - linha, coluna - 'a');
    }
    protected static XadrezPosition fromPosition(Position position){
        return new XadrezPosition((char)('a' + position.getColuna()), 8 - position.getLinha());
    }
    @Override
    public String toString(){
        return "" + coluna + linha;
    }
}
