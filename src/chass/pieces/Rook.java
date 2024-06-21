package chass.pieces;

import boardgame.Board;
import chass.ChassPiece;
import chass.Color;

public class Rook extends ChassPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}

	
	
	
	@Override
	public String toString() {
		return "R";
	}
	
	
	
}