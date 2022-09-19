package application;

import chess.Partida;
import chess.PecaXadrez;
import chess.XadrezException;
import chess.XadrezPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Scanner scanner = new Scanner(System.in);
        List<PecaXadrez> capturadas = new ArrayList<>();
        while (true) {
            try {
                UI.clearScreen();
                UI.printPartida(partida, capturadas);
                System.out.println();
                System.out.print("Origem: ");
                XadrezPosition origem = UI.lerXadrezPosition(scanner);

                boolean[][] movimentosPossiveis = partida.possiveisMovimentos(origem);
                UI.clearScreen();
                UI.printTabuleiro(partida.getPecas(), movimentosPossiveis);


                System.out.println();
                System.out.print("Destino: ");
                XadrezPosition destino = UI.lerXadrezPosition(scanner);

                PecaXadrez pecaCapturada = partida.executarMovimentoXadrez(origem, destino);

                if (pecaCapturada != null) {
                    capturadas.add(pecaCapturada);
                }
            } catch (XadrezException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
