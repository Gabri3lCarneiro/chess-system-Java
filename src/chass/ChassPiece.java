package chass;

import boardgame.Board;
import boardgame.Piece;

public class ChassPiece extends Piece {

	private Color color;

	
	public ChassPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}


	
	public Color getColor() {
		return color;
	}
}
