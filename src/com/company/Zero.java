package com.company;

public class Zero extends AbstractPiece{
    Zero (boolean color, String type, int indexBoard) {
        this.white = color;
        this.type = type;
        this.indexBoard = indexBoard;
    }
    public boolean moveTo(int indexToMove){return true;}
}
