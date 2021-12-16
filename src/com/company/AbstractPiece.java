package com.company;

import java.util.Locale;
import java.util.Scanner;

public abstract class AbstractPiece {
    protected boolean white;
    protected String type;
    protected int indexBoard;
    protected boolean statusTooMove;
    protected boolean enableForCastling;

    public abstract boolean moveTo(int indexToMove);

    public int getIndexBoard() {return indexBoard;}

    public String getTypePiece() {return type;}

    public boolean getColor() {return white;}

    public String paint() {
        if (type.equals("0")) return("　");
        else if (type.equals("1") && white) return("♟");
        else if (type.equals("2") && white) return("♞");
        else if (type.equals("3") && white) return("♝");
        else if (type.equals("4") && white) return("♜");
        else if (type.equals("5") && white) return("♛");
        else if (type.equals("6") && white) return("♚");
        else if (type.equals("1") && white == false) return("♙");
        else if (type.equals("2") && white == false) return("♘");
        else if (type.equals("3") && white == false) return("♗");
        else if (type.equals("4") && white == false) return("♖");
        else if (type.equals("5") && white == false) return("♕");
        else if (type.equals("6") && white == false) return("♔");
        return ("a");
    }
}
