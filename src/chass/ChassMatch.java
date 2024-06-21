package chass;

import boardgame.Board;
import chass.pieces.King;
import chass.pieces.Rook;

public class ChassMatch {

	private Board board;
	
	
	public ChassMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChassPiece[][] getPices(){
		ChassPiece[][] mat = new ChassPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChassPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	
	private void placeNewPiece(char column, int row, ChassPiece piece) {
		board.placePiece(piece, new ChassPosition(column, row).toPosition());
	}
	private void initialSetup() {

		
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));

	
	}
	
	/*public ChassPiece[][] getPices(){
		ChassPiece[][] mat = new ChassPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChassPiece) board.piece(i, j);
			}
		}
		return mat;
	}*/
	
	
	
}
