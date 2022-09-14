package application;

import chess.Partida;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        UI.printTabuleiro(partida.getPecas());
    }
}
