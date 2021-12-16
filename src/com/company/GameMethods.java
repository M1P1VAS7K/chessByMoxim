package com.company;

public class GameMethods {
    public static void startingPosition() {
        for (int i = 0; i < 8; i++) {
            Main.chessBoard[1][i] = new Pawn(false, "1", 8 + i, false);
            Main.blackPiecesList[i] = Main.chessBoard[1][i];
            Main.chessBoard[6][i] = new Pawn(true, "1", 48 + i, false);
            Main.whitePiecesList[i] = Main.chessBoard[6][i];
        }
        Main.chessBoard[0][0] = new Rook(false, "4", 0, true);
        Main.chessBoard[0][7] = new Rook(false, "4", 7, true);
        Main.blackPiecesList[8] = Main.chessBoard[0][0];
        Main.blackPiecesList[9] = Main.chessBoard[0][7];
        Main.chessBoard[7][0] = new Rook(true, "4", 56, true);
        Main.chessBoard[7][7] = new Rook(true, "4", 63, true);
        Main.whitePiecesList[8] = Main.chessBoard[7][0];
        Main.whitePiecesList[9] = Main.chessBoard[7][7];

        Main.chessBoard[0][1] = new Knight(false, "2", 1);
        Main.chessBoard[0][6] = new Knight(false, "2", 6);
        Main.blackPiecesList[10] = Main.chessBoard[0][1];
        Main.blackPiecesList[11] = Main.chessBoard[0][6];
        Main.chessBoard[7][1] = new Knight(true, "2", 57);
        Main.chessBoard[7][6] = new Knight(true, "2", 62);
        Main.whitePiecesList[10] = Main.chessBoard[7][1];
        Main.whitePiecesList[11] = Main.chessBoard[7][6];

        Main.chessBoard[0][2] = new Bishop(false, "3", 2);
        Main.chessBoard[0][5] = new Bishop(false, "3", 5);
        Main.blackPiecesList[12] = Main.chessBoard[0][2];
        Main.blackPiecesList[13] = Main.chessBoard[0][5];
        Main.chessBoard[7][2] = new Bishop(true, "3", 58);
        Main.chessBoard[7][5] = new Bishop(true, "3", 61);
        Main.whitePiecesList[12] = Main.chessBoard[7][2];
        Main.whitePiecesList[13] = Main.chessBoard[7][5];


        Main.chessBoard[0][3] = new Queen(false, "5", 3);
        Main.chessBoard[0][4] = new King(false, "6", 4, true);
        Main.blackPiecesList[14] = Main.chessBoard[0][3];
        Main.blackPiecesList[15] = Main.chessBoard[0][4];
        Main.chessBoard[7][3] = new Queen(true, "5", 59);
        Main.chessBoard[7][4] = new King(true, "6", 60, true);
        Main.whitePiecesList[14] = Main.chessBoard[7][3];
        Main.whitePiecesList[15] = Main.chessBoard[7][4];

        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                Main.chessBoard[j][i] = new Zero(false, "0", j * 8 + i);
            }
        }
    }

    public static void drawBoard() {
        System.out.println();
        System.out.println("----------------------");
        for (int i = 0; i < 8; i++) {
            System.out.println("|" + Main.chessBoard[i][0].paint() +
                    "|" + Main.chessBoard[i][1].paint() +
                    "|" + Main.chessBoard[i][2].paint() +
                    "|" + Main.chessBoard[i][3].paint() +
                    "|" + Main.chessBoard[i][4].paint() +
                    "|" + Main.chessBoard[i][5].paint() +
                    "|" + Main.chessBoard[i][6].paint() +
                    "|" + Main.chessBoard[i][7].paint() + "|");
            System.out.println("----------------------");
        }
        System.out.println();
    }

    public static void enterMove() {
        System.out.println("Введите ващ ход");
        String pMove = Main.in.next();
        if (pMove.equals("q")) System.exit(0);
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        try {
            s1 = Character.toString(pMove.charAt(0));
            s2 = Character.toString(pMove.charAt(1));
            s3 = Character.toString(pMove.charAt(2));
            s4 = Character.toString(pMove.charAt(3));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Неверные данные");
            return;
        }
        int s1_n = -1;
        int s2_n = -1;
        int s3_n = -1;
        int s4_n = -1;
        try {
            s2_n = Math.abs(Integer.valueOf(s2) - 1 -  7);
            if (!(s2_n >= 0 && s2_n <= 8)) {
                System.out.println("Неверные данные");
                return;
            }
            s4_n = Math.abs(Integer.valueOf(s4) - 1 - 7);
            if (!(s4_n >= 0 && s4_n <= 8)) {
                System.out.println("Неверные данные");
                return;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Неверные данные");
            return;
        }
        switch (s1) {
            case "a":
                s1_n = 0;
                break;
            case "b":
                s1_n = 1;
                break;
            case "c":
                s1_n = 2;
                break;
            case "d":
                s1_n = 3;
                break;
            case "e":
                s1_n = 4;
                break;
            case "f":
                s1_n = 5;
                break;
            case "g":
                s1_n = 6;
                break;
            case "h":
                s1_n = 7;
                break;
            default:
                System.out.println("Неверные данные");
                return;
        }

        switch (s3) {
            case "a":
                s3_n = 0;
                break;
            case "b":
                s3_n = 1;
                break;
            case "c":
                s3_n = 2;
                break;
            case "d":
                s3_n = 3;
                break;
            case "e":
                s3_n = 4;
                break;
            case "f":
                s3_n = 5;
                break;
            case "g":
                s3_n = 6;
                break;
            case "h":
                s3_n = 7;
                break;
            default:
                System.out.println("Неверные данные");
                return;
        }
        if (Main.chessBoard[s2_n][s1_n].type.equals("0")) System.out.println("Выбрано пустое поле");
        else if (Main.chessBoard[s2_n][s1_n].moveTo(Main.chessBoard[s4_n][s3_n].getIndexBoard())) {
            Main.movePlayerColor += 1;
        } else {
            System.out.println("Ход невозможен");
        }
    }
}
