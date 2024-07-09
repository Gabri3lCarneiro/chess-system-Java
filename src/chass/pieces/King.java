package chass.pieces;

import boardgame.Board;
import boardgame.Position;
import chass.ChassMatch;
import chass.ChassPiece;
import chass.Color;

public class King extends ChassPiece {

	private ChassMatch chassMatch;
	
	
	
	
	
	public King(Board board, Color color, ChassMatch chassMatch) {
		super(board, color);
		this.chassMatch = chassMatch;

	}
	
	
	private boolean testRookCastling(Position position) {
		ChassPiece p = (ChassPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	

	@Override
	public String toString() {
		return "k";
	}

	private boolean canMove(Position position) {
		ChassPiece p = (ChassPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Nw
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Ne
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Sw
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Se
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}	
			
			
		// special move castling
		if(getMoveCount() == 0 && !chassMatch.getCheck() ) {
			Position positionR1 = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(positionR1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
		}
			
		if(getMoveCount() == 0 && !chassMatch.getCheck() ) {
			Position positionR2 = new Position(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(positionR2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && (getBoard().piece(p3) == null )) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
			
		
		return mat;
	}

}
