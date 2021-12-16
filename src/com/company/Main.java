package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static AbstractPiece[][] chessBoard = new AbstractPiece[8][8];
    public static AbstractPiece[] blackPiecesList = new AbstractPiece[16];
    public static AbstractPiece[] whitePiecesList = new AbstractPiece[16];
    public static int movePlayerColor = 0;

    public static void main(String[] args) {
        System.out.println("Приветсвую вас в игре 'Chess rush' чтобы начать нажмите '1' что бы выйти из игры напишите 'q'.");
        while (true) {
            String res = in.next();
            if (res.equals("q")) {
                System.exit(0);
            } else if (res.equals("1")) {
                System.out.println("Да начнётся игра");
                break;
            } else {
                System.out.println("Ошибка ввода команда " + res + " неизвестна");
            }
        }
        System.out.println("Поговори о правилах.");
        System.out.println("Игра на 2 человек. `Первые ходят белые");
        System.out.println("В основе лежат стандартные правила и игра идёт без учёта времени.");
        System.out.println("Во избижания двумесленных ходов в игре используется тривиальная система ходов и учёт правил AN.");
        System.out.println("Вы указываете клетку на которой стоит фигура и потом указывете клетку на которую хотите " +
                "переместить фигуру");
        System.out.println("Примеры ходов ->");
        System.out.println("Дебют -> 'e2e4' (пешка белых перемещается с поля e2 на поле e4)");
        System.out.println("Дебют -> 'd7d5' (пешка чёрных перемещается с поля d7 на поле d5)");
        System.out.println("Дебют -> 'e4d5' (взятие чёрной пешки белой перемещение белой пешки с поля e4 на поле d5)");

        GameMethods.startingPosition();

        while (true) {
            GameMethods.drawBoard();
            GameMethods.enterMove();

        }
    }
}
