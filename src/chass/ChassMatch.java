package chass;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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
	
	public ChassPiece performChessMove(ChassPosition sourcePosition, ChassPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validadeSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = mekeMove(source, target);
		return (ChassPiece) capturedPiece;
	}
	
	private Piece mekeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	
	}
	
	private void validadeSourcePosition(Position position) {
		if(!board.therIsAPiece(position)) {
			throw new ChassException("There is no piece on source position");
		}
		if(!board.piece(position).isThereAnyPossibleMovie()) {
			throw new ChassException("There is no possible moves for the chosen piece ");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
		throw new ChassException("The choses piece can't move to target position");
		}
	}
	

	private void placeNewPiece(char column, int row, ChassPiece piece) {
		board.placePiece(piece, new ChassPosition(column, row).toPosition());
	}
	private void initialSetup() {

		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
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