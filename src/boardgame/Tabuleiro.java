package boardgame;

import chess.PecaXadrez;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1){
            throw new TabuleiroException("Erro ao criar o tabuleiro: É necessário que tenha pelo menos uma linha e uma coluna.");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }
    public int getLinhas() {
        return linhas;
    }
    public int getColunas() {
        return colunas;
    }
    public Peca peca(int linha, int coluna){
        if (!posicaoExiste(linha, coluna)){
            throw new TabuleiroException("Posição não existe no tabuleiro.");
        }
        return pecas[linha][coluna];
    }
    public Peca peca(Position position){
        if (!posicaoExiste(position)){
            throw new TabuleiroException("Posição não existe no tabuleiro.");
        }
        return pecas[position.getLinha()][position.getColuna()];
    }
    public void colocarPeca(Peca peca, Position position){
        if (issoEUmaPeca(position)){
            throw new TabuleiroException("Já existe esta peça na posição " + position + ".");
        }
        pecas[position.getLinha()][position.getColuna()] = peca;
        peca.position = position;
    }
    private Boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }
    public Boolean posicaoExiste(Position position){
        return posicaoExiste(position.getLinha(), position.getColuna());
    }

    public Boolean issoEUmaPeca(Position position){
        if (!posicaoExiste(position)){
            throw new TabuleiroException("Posição não existe no tabuleiro.");
        }
        return peca(position) != null;
    }
    public Peca removerPeca(Position position){
        if (!posicaoExiste(position)){
            throw new TabuleiroException("Posição não existe no tabuleiro.");
        }
        if (peca(position) == null) {
            return null;
        } else {
            Peca aux = peca(position);
            aux.position = null;
            pecas[position.getLinha()][position.getColuna()] = null;
            return aux;
        }
    }
}
