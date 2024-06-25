package chass.pieces;

import boardgame.Board;
import chass.ChassPiece;
import chass.Color;

public class King extends ChassPiece{

	public King(Board board, Color color) {
		super(board, color);
		
	}

	
	
	@Override
	public String toString() {
		return "k";
	}



	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		return mat;
	}
}
