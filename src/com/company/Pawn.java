package com.company;

public class Pawn extends AbstractPiece {
    boolean tooMove = true;

    Pawn(boolean color, String type, int indexBoard, boolean statusTooMove) {
        this.white = color;
        this.type = type;
        this.indexBoard = indexBoard;
        this.statusTooMove = statusTooMove;
    }

    public boolean moveTo(int indexToMove) {
        int checkerColor = -1;
        if (this.white) checkerColor = 0;
        else checkerColor = 1;
        if (!(checkerColor == Main.movePlayerColor % 2)) {
            System.out.println("Сейчас ходят " + ((Main.movePlayerColor % 2 == 1) ? "чёрные" : "белые"));
            return false;
        }
        if (Main.movePlayerColor % 2 == 1) {
            for(AbstractPiece x: Main.blackPiecesList) {
                if (x.type.equals("1")) {
                    int z = x.indexBoard;
                    Main.chessBoard[z/8][z%8].statusTooMove = false;
                }
            }
        } else {
            for(AbstractPiece x: Main.whitePiecesList) {
                if (x.type.equals("1")) {
                    int z = x.indexBoard;
                    Main.chessBoard[z/8][z%8].statusTooMove = false;
                }
            }
        }
        if (Math.abs(this.indexBoard - indexToMove) == 16) {
            if (!tooMove) {
                System.out.println("Невозможен ход пешкой на 2 поля вперёд");
                return false;
            } else {
                if (Main.movePlayerColor % 2 == 1) {
                    if (!(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0") &&
                            Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8].type.equals("0"))) {
                        System.out.println("Ход заблокирован");
                        return false;
                    }
                } else {
                    if (!(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0") &&
                            Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8].type.equals("0"))) {
                        System.out.println("Ход заблокирован");
                        return false;
                    }
                }
            }
            Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
            Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
            statusTooMove = true;
        } else {
            if (Math.abs(this.indexBoard - indexToMove) == 8) {
                if (Main.movePlayerColor % 2 == 1) {
                    if (!(this.indexBoard - indexToMove < 0)) {
                        System.out.println("Ход сделан не в ту сторону");
                        return false;
                    }
                } else {
                    if(!(this.indexBoard - indexToMove > 0)){
                        System.out.println("Ход сделан не в ту сторону");
                        return false;
                    }
                }
                if (!(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0"))) {
                    System.out.println("Ход заблокирован");
                    return false;
                }
                Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
            }
            else if (Math.abs(this.indexBoard - indexToMove) == 7){

                if (Main.movePlayerColor % 2 == 1 && this.indexBoard - indexToMove == -7) {
                    if(Main.chessBoard[indexToMove / 8][indexToMove % 8].white &&
                            !(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0"))) {
                        if(!blackCh()) {
                            for(int i =0; i < 8; i++) {
                                if (Main.whitePiecesList[i] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                                    Main.whitePiecesList[i] = new Zero(false, "0", -1);
                                }
                            }
                            Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                            Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                        }else return false;

                    } else if (Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0") &&
                            Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8].white &&
                            Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8].statusTooMove) {
                        for(int i =0; i < 8; i++) {
                            if (Main.whitePiecesList[i] == Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8]){
                                Main.whitePiecesList[i] = new Zero(false, "0", -1);
                            }
                        }
                        Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                        Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8] = new Zero(false, "0", indexToMove);
                        Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    }
                    else return false;

                } else if (Main.movePlayerColor % 2 == 0 && this.indexBoard - indexToMove == 7){
                    if(!(Main.chessBoard[indexToMove / 8][indexToMove % 8].white) &&
                            !(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0"))) {
                        if(!whiteCh()) {
                            for(int i =0; i < 8; i++) {
                                if (Main.blackPiecesList[i] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                                    Main.blackPiecesList[i] = new Zero(false, "0", -1);
                                }
                            }
                            Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                            Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                        }else return false;

                    }else if (Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0") &&
                            !(Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8].white) &&
                            Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8].statusTooMove) {
                        for(int i =0; i < 8; i++) {
                            if (Main.blackPiecesList[i] == Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8]){
                                Main.blackPiecesList[i] = new Zero(false, "0", -1);
                            }
                        }
                        Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                        Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8] = new Zero(false, "0", indexToMove);
                        Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    }
                    else return false;
                }
            }

            else if (Math.abs(this.indexBoard - indexToMove) == 9){

                if (Main.movePlayerColor % 2 == 1 && this.indexBoard - indexToMove == -9) {
                    if(Main.chessBoard[indexToMove / 8][indexToMove % 8].white &&
                            !(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0"))) {
                        if(!blackCh()) {
                            for(int i =0; i < 8; i++) {
                                if (Main.whitePiecesList[i] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                                    Main.whitePiecesList[i] = new Zero(false, "0", -1);
                                }
                            }
                            Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                            Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                        } else return false;

                    }else if (Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0") &&
                            Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8].white &&
                            Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8].statusTooMove) {
                        for(int i =0; i < 8; i++) {
                            if (Main.whitePiecesList[i] == Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8]){
                                Main.whitePiecesList[i] = new Zero(false, "0", -1);
                            }
                        }
                        Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                        Main.chessBoard[(indexToMove / 8) - 1][indexToMove % 8] = new Zero(false, "0", indexToMove);
                        Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    }else return false;

                } else if (Main.movePlayerColor % 2 == 0 && this.indexBoard - indexToMove == 9){
                    if(!(Main.chessBoard[indexToMove / 8][indexToMove % 8].white) &&
                            !(Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0"))) {
                        if(!whiteCh()) {
                            for(int i =0; i < 8; i++) {
                                if (Main.blackPiecesList[i] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                                    Main.blackPiecesList[i] = new Zero(false, "0", -1);
                                }
                            }
                            Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                            Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                        } else return false;
                    } else if (Main.chessBoard[indexToMove / 8][indexToMove % 8].type.equals("0") &&
                            !(Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8].white) &&
                            Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8].statusTooMove) {
                        for(int i =0; i < 8; i++) {
                            if (Main.blackPiecesList[i] == Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8]){
                                Main.blackPiecesList[i] = new Zero(false, "0", -1);
                            }
                        }
                        Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8];
                        Main.chessBoard[(indexToMove / 8) + 1][indexToMove % 8] = new Zero(false, "0", indexToMove);
                        Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    }else return false;
                }
            }
            else {
                System.out.println("Неправильный ход пешкой.");
                return false;
            }
        }

        tooMove = false;
        this.indexBoard = indexToMove;
        if (0 <= this.indexBoard && this.indexBoard <= 7 && this.white) {
            System.out.println("Выберите тип фигуры от 1 до 4");
            System.out.println("1 - Конь ♞");
            System.out.println("2 - Слон ♝");
            System.out.println("3 - Ладья ♜");
            System.out.println("4 - Королева ♛");
            int zCheckerPawn = 0;
            while (zCheckerPawn == 0) {
                String num = Character.toString(Main.in.next().charAt(0));
                switch (num) {
                    case "1":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.whitePiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Knight(true, "2", this.indexBoard);
                                Main.whitePiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    case "2":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.whitePiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Bishop(true, "3", this.indexBoard);
                                Main.whitePiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    case "3":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.whitePiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Rook(true, "4", this.indexBoard, false);
                                Main.whitePiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    case "4":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.whitePiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Queen(true, "5", this.indexBoard);
                                Main.whitePiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    default:
                        System.out.println("Неверно выбрана вигура");
                        break;
                }
            }
            GameMethods.drawBoard();
        } else if (56 <= this.indexBoard && this.indexBoard <= 63 && !(this.white)) {
            System.out.println("Выберите тип фигуры от 1 до 4");
            System.out.println("1 - Конь ♘");
            System.out.println("2 - Слон ♗");
            System.out.println("3 - Ладья ♖");
            System.out.println("4 - Королева ♕");
            int zCheckerPawn = 0;
            while (zCheckerPawn == 0) {
                String num = Character.toString(Main.in.next().charAt(0));
                switch (num) {
                    case "1":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.blackPiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Knight(false, "2", this.indexBoard);
                                Main.blackPiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    case "2":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.blackPiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Bishop(false, "3", this.indexBoard);
                                Main.blackPiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    case "3":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.blackPiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Rook(false, "4", this.indexBoard, false);
                                Main.blackPiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    case "4":
                        zCheckerPawn += 1;
                        for(int i =0; i < 8; i++) {
                            if (Main.blackPiecesList[i] == Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8]){
                                Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8] = new Queen(false, "5", this.indexBoard);
                                Main.blackPiecesList[i] = Main.chessBoard[(this.indexBoard / 8)][this.indexBoard % 8];
                            }
                        }break;
                    default:
                        System.out.println("Неверно выбрана вигура");
                        break;
                }
            }
            GameMethods.drawBoard();
        }
        return true;
    }

    public boolean whiteCh() {
        return false;
    }

    public boolean blackCh() {
        return false;
    }
}
