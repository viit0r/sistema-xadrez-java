package application;

import chess.Partida;
import chess.PecaXadrez;
import chess.XadrezException;
import chess.XadrezPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                UI.clearScreen();
                UI.printTabuleiro(partida.getPecas());
                System.out.println();
                System.out.print("Origem: ");
                XadrezPosition origem = UI.lerXadrezPosition(scanner);
                System.out.println();
                System.out.print("Destino: ");
                XadrezPosition destino = UI.lerXadrezPosition(scanner);

                PecaXadrez pecaCapturada = partida.executarMovimentoXadrez(origem, destino);
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
