package com.company;

public class Bishop extends AbstractPiece {
    Bishop(boolean color, String type, int indexBoard) {
        this.white = color;
        this.type = type;
        this.indexBoard = indexBoard;
    }

    public boolean moveTo(int indexToMove) {
        int checkerColor = -1;
        if (this.white) checkerColor = 0;
        else checkerColor = 1;
        if (!(checkerColor == Main.movePlayerColor % 2)) {
            System.out.println("Сейчас ходят " + ((Main.movePlayerColor % 2 == 1) ? "чёрные" : "белые"));
            return false;
        }
        int iCheckerMove = this.indexBoard / 8;
        int yCheckerMove = this.indexBoard % 8;
        int maxHighLeft =Math.min(Math.abs(0 - iCheckerMove), Math.abs(0 - yCheckerMove));
        int maxHighRight = Math.min(Math.abs(0 - iCheckerMove), Math.abs(7 - yCheckerMove));
        int minHighLeft = Math.min(Math.abs(7 - iCheckerMove), Math.abs(0 - yCheckerMove));
        int minHighRight = Math.min(Math.abs(7 - iCheckerMove), Math.abs(7 - yCheckerMove));
        System.out.println(maxHighLeft);
        System.out.println(maxHighRight);
        System.out.println(minHighLeft);
        System.out.println(minHighRight);

        if (Main.movePlayerColor % 2 == 0) {
            for (int i = 1; i < maxHighLeft + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 - i].type.equals("0") && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 - i)) {
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if (!(Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 - i].white) && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 - i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 - i].white) break;
            }

            for (int i = 1; i < maxHighRight + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 + i].type.equals("0") && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 + i)) {
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if (!(Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 + i].white) && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 + i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 + i].white) break;
            }

            for (int i = 1; i < minHighLeft + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 - i].type.equals("0") && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 - i)) {
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if (!(Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 - i].white) && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 - i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 - i].white) break;
            }

            for (int i = 1; i < minHighRight + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 + i].type.equals("0") && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 + i)){
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if (!(Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 + i].white) && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 + i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 + i].white) break;
            }
        }
        else {
            for (int i = 1; i < maxHighLeft + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 - i].type.equals("0") && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 - i)) {
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if ((Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 - i].white) && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 - i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (!(Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 - i].white)) break;
            }

            for (int i = 1; i < maxHighRight + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 + i].type.equals("0") && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 + i)) {
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if ((Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 + i].white) && indexToMove == ((this.indexBoard / 8) - i)* 8 + (this.indexBoard % 8 + i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (!(Main.chessBoard[(this.indexBoard / 8)- i][this.indexBoard % 8 + i].white)) break;
            }

            for (int i = 1; i < minHighLeft + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 - i].type.equals("0") && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 - i)) {
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if ((Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 - i].white) && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 - i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (!(Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 - i].white)) break;
            }

            for (int i = 1; i < minHighRight + 1; i++) {
                if (Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 + i].type.equals("0") && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 + i)){
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
                else if ((Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 + i].white) && indexToMove == ((this.indexBoard / 8) + i)* 8 + (this.indexBoard % 8 + i)) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[(indexToMove / 8)][indexToMove % 8]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[indexToMove / 8][indexToMove % 8] = Main.chessBoard[this.indexBoard/8][this.indexBoard%8];
                    Main.chessBoard[this.indexBoard / 8][this.indexBoard % 8] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }else if (!(Main.chessBoard[(this.indexBoard / 8)+ i][this.indexBoard % 8 + i].white)) break;
            }
        }
        return false;
    }

    public boolean whiteCh() {
        return true;
    }

    public boolean blackCh() {
        return true;
    }
}
