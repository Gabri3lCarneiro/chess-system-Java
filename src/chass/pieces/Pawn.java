package chass.pieces;

import boardgame.Board;
import boardgame.Position;
import chass.ChassMatch;
import chass.ChassPiece;
import chass.Color;

public class Pawn extends ChassPiece {

	private ChassMatch chassMatch;
	
	
	
	public Pawn(Board board, Color color, ChassMatch chassMatch) {
		super(board, color);
		this.chassMatch = chassMatch;

	}

	@Override
	public String toString() {
		return "P";
	}
	

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		if (getColor() == getColor().WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			Position p2 = new Position(position.getRow() - 2, position.getColumn());
			p.setValues(position.getRow() - 2, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p) && getMoveCount() == 0
					&& getBoard().positionExists(p2) && !getBoard().therIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//enPassant
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chassMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
					
				}
				Position right = new Position(position.getRow(), position.getColumn()+ 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chassMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
					
				}
			}
			
			
			
			
		} else {

			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			Position p2 = new Position(position.getRow() + 2, position.getColumn());
			p.setValues(position.getRow() + 2, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p) && getMoveCount() == 0
					&& getBoard().positionExists(p2) && !getBoard().therIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//enPassant
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chassMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
					
				}
				Position right = new Position(position.getRow(), position.getColumn() +  1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chassMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
			}
		}

		return mat;
	}

}
