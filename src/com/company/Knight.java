package com.company;

public class Knight extends AbstractPiece{
    Knight (boolean color, String type, int indexBoard) {
        this.white = color;
        this.type = type;
        this.indexBoard = indexBoard;
    }
    public boolean moveTo(int indexToMove){
        int checkerColor = -1;
        if (this.white) checkerColor = 0;
        else checkerColor = 1;
        if (!(checkerColor == Main.movePlayerColor % 2)) {
            System.out.println("Сейчас ходят " + ((Main.movePlayerColor % 2 == 1) ? "чёрные" : "белые"));
            return false;
        }
        int cellINow = this.indexBoard / 8;
        int cellYNow = this.indexBoard % 8;
        int cellIAfter = indexToMove / 8;
        int cellYAfter = indexToMove % 8;

        try {
            if(Main.chessBoard[cellIAfter - 2][cellYAfter + 1].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter - 2][cellYAfter - 1].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter - 1][cellYAfter + 2].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter + 1][cellYAfter + 2].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter + 2][cellYAfter - 1].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter + 2][cellYAfter + 1].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter - 1][cellYAfter - 2].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        try {
            if(Main.chessBoard[cellIAfter + 1][cellYAfter - 2].white != Main.chessBoard[cellINow][cellYNow].white) {
                if(Main.movePlayerColor % 2 == 0) {
                    for(int j =0; j < 8; j++) {
                        if (Main.blackPiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.blackPiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                } else {
                    for(int j =0; j < 8; j++) {
                        if (Main.whitePiecesList[j] == Main.chessBoard[cellIAfter][cellYAfter]){
                            Main.whitePiecesList[j] = new Zero(false, "0", -1);
                        }
                    }
                    Main.chessBoard[cellIAfter][cellYAfter] = Main.chessBoard[cellINow][cellYNow];
                    Main.chessBoard[cellINow][cellYNow] = new Zero(false, "0", this.indexBoard);
                    this.indexBoard = indexToMove;
                    return true;
                }
            }
        }
        catch(Exception ex){}
        return false;
    }

    public boolean whiteCh(){return true;}
    public boolean blackCh(){return true;}
}
