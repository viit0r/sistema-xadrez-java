package chess;

import boardgame.Peca;
import boardgame.Position;
import boardgame.Tabuleiro;
import chess.pecas.Rei;
import chess.pecas.Torre;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private Tabuleiro tabuleiro;
    private int turno;
    private Color jogadorAtual;
    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    public Partida(){
        tabuleiro = new Tabuleiro(8, 8);
        turno = 1;
        jogadorAtual = Color.WHITE;
        setupInicial();
    }
    public int getTurno() {
        return turno;
    }
    public Color getJogadorAtual() {
        return jogadorAtual;
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

    public boolean[][] possiveisMovimentos(XadrezPosition posicaoOrigem){
        Position position = posicaoOrigem.toPosition();
        validarPosicaoOrigem(position);
        return tabuleiro.peca(position).possiveisMovimentos();
    }

    public PecaXadrez executarMovimentoXadrez(XadrezPosition posicaoOrigem, XadrezPosition posicaoDestino){
        Position origem = posicaoOrigem.toPosition();
        Position destino = posicaoDestino.toPosition();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca pecaCapturada = realizarMovimento(origem, destino);
        proximoTurno();
        return (PecaXadrez) pecaCapturada;
    }

    private Peca realizarMovimento(Position origem, Position destino){
        Peca p =  tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);

        if (pecaCapturada != null){
            pecasNoTabuleiro.remove(pecaCapturada);
            pecasCapturadas.add(pecaCapturada);
        }
        return pecaCapturada;
    }

    private void validarPosicaoOrigem(Position position){
        if (!tabuleiro.issoEUmaPeca(position)) {
            throw new XadrezException("Não existe peça na posição de origem.");
        }
        if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(position)).getColor()){
            throw new XadrezException("A peça escolhida não é sua.");
        }
        if (!tabuleiro.peca(position).existeAlgumMovimentoPossivel()){
            throw new XadrezException("Não existe movimentos possíveis para a peça escolhida.");
        }
    }

    private void validarPosicaoDestino(Position origem, Position destino){
        if(!tabuleiro.peca(origem).possivelMovimento(destino)){
            throw new XadrezException("A peça escolhida não pode se mover para a posição de destino.");
        }
    }

    private void proximoTurno(){
        turno++;
        jogadorAtual = (jogadorAtual == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void colocaNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new XadrezPosition(coluna, linha).toPosition());
        pecasNoTabuleiro.add(peca);
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
