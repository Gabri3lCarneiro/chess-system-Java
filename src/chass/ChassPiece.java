package chass;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChassPiece extends Piece {

	private Color color;

	public ChassPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public ChassPosition getChassPosition() {
		return ChassPosition.fromPosition(position);
	}
	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece(Position position) {
		ChassPiece p = (ChassPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;

	}

}