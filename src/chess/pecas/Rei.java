package chess.pecas;

import boardgame.Position;
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

    public boolean podeMover(Position position){
        PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(position);
        return peca == null || peca.getColor() != getColor();
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean [][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Position aux = new Position(0,0);

        //acima
        aux.setValues(position.getLinha() - 1, position.getColuna());
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }
        //abaixo
        aux.setValues(position.getLinha() + 1, position.getColuna());
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //esquerda
        aux.setValues(position.getLinha(), position.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //direita
        aux.setValues(position.getLinha(), position.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //noroeste
        aux.setValues(position.getLinha() - 1, position.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //nordeste
        aux.setValues(position.getLinha() - 1, position.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //sudoeste
        aux.setValues(position.getLinha() + 1, position.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //sudeste
        aux.setValues(position.getLinha() + 1, position.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(aux) && podeMover(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }


        return mat;
    }
}
