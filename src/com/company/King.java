package com.company;

public class King extends AbstractPiece{
    King (boolean color, String type, int indexBoard, boolean enableForCastling) {
        this.white = color;
        this.type = type;
        this.indexBoard = indexBoard;
        this.enableForCastling = enableForCastling;
    }
    public boolean moveTo(int indexToMove){return true;}
}
