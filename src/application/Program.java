package application;

import chess.Partida;
import chess.PecaXadrez;
import chess.XadrezPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            UI.printTabuleiro(partida.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            XadrezPosition origem = UI.lerXadrezPosition(scanner);
            System.out.println();
            System.out.print("Destino: ");
            XadrezPosition destino = UI.lerXadrezPosition(scanner);

            PecaXadrez pecaCapturada = partida.executarMovimentoXadrez(origem, destino);
        }
    }
}
