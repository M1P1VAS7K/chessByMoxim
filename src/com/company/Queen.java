package com.company;

public class Queen extends AbstractPiece{
    Queen (boolean color, String type, int indexBoard) {
        this.white = color;
        this.type = type;
        this.indexBoard = indexBoard;
    }
    public boolean moveTo(int indexToMove){return true;}
    public boolean whiteCh(){return true;}
    public boolean blackCh(){return true;}
}
