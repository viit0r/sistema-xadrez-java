package chess;

import boardgame.Peca;
import boardgame.Position;
import boardgame.Tabuleiro;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class Partida {
    private Tabuleiro tabuleiro;

    public Partida(){
        tabuleiro = new Tabuleiro(8, 8);
        setupInicial();
    }
    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++){
            for (int j = 0; j < tabuleiro.getColunas(); j++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    public PecaXadrez executarMovimentoXadrez(XadrezPosition posicaoOrigem, XadrezPosition posicaoDestino){
        Position origem = posicaoOrigem.toPosition();
        Position destino = posicaoDestino.toPosition();
        validarPosicaoOrigem(origem);
        Peca pecaCapturada = realizarMovimento(origem, destino);
        return (PecaXadrez) pecaCapturada;
    }

    private Peca realizarMovimento(Position origem, Position destino){
        Peca p =  tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);
        return pecaCapturada;
    }

    private void validarPosicaoOrigem(Position position){
        if (!tabuleiro.issoEUmaPeca(position)) {
            throw new XadrezException("Não existe peça na posição de origem.");
        }
    }

    private void colocaNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new XadrezPosition(coluna, linha).toPosition());
    }
    private void setupInicial(){
        colocaNovaPeca('c', 1, new Torre(tabuleiro, Color.WHITE));
        colocaNovaPeca('c', 2, new Torre(tabuleiro, Color.WHITE));
        colocaNovaPeca('d', 2, new Torre(tabuleiro, Color.WHITE));
        colocaNovaPeca('e', 2, new Torre(tabuleiro, Color.WHITE));
        colocaNovaPeca('e', 1, new Torre(tabuleiro, Color.WHITE));
        colocaNovaPeca('d', 1, new Rei(tabuleiro, Color.WHITE));

        colocaNovaPeca('c', 7, new Torre(tabuleiro, Color.BLACK));
        colocaNovaPeca('c', 8, new Torre(tabuleiro, Color.BLACK));
        colocaNovaPeca('d', 7, new Torre(tabuleiro, Color.BLACK));
        colocaNovaPeca('e', 7, new Torre(tabuleiro, Color.BLACK));
        colocaNovaPeca('e', 8, new Torre(tabuleiro, Color.BLACK));
        colocaNovaPeca('d', 8, new Rei(tabuleiro, Color.BLACK));
    }
}
