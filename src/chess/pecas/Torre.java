package chess.pecas;

import boardgame.Position;
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

        Position aux = new Position(0,0);

        //acima
        aux.setValues(position.getLinha() - 1, position.getColuna());
        while (getTabuleiro().posicaoExiste(aux) && !getTabuleiro().issoEUmaPeca(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
            aux.setLinha(aux.getLinha() - 1);
        }
        if (getTabuleiro().posicaoExiste(aux) && existePecaOponente(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //esquerda
        aux.setValues(position.getLinha(), position.getColuna() - 1);
        while (getTabuleiro().posicaoExiste(aux) && !getTabuleiro().issoEUmaPeca(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
            aux.setColuna(aux.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExiste(aux) && existePecaOponente(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //direita
        aux.setValues(position.getLinha(), position.getColuna() + 1);
        while (getTabuleiro().posicaoExiste(aux) && !getTabuleiro().issoEUmaPeca(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
            aux.setColuna(aux.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExiste(aux) && existePecaOponente(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }

        //baixo
        aux.setValues(position.getLinha() + 1 , position.getColuna());
        while (getTabuleiro().posicaoExiste(aux) && !getTabuleiro().issoEUmaPeca(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
            aux.setLinha(aux.getLinha() + 1);
        }
        if (getTabuleiro().posicaoExiste(aux) && existePecaOponente(aux)){
            mat[aux.getLinha()][aux.getColuna()] = true;
        }
        return mat;
    }
}
