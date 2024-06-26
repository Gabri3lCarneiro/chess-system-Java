package chass;

import boardgame.Position;

public class ChassPosition {

	private char column;
	private int row;
	
	
	public ChassPosition(char column, Integer row) {

		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChassException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}


	
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	
	public Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChassPosition fromPosition(Position position) {
		return new ChassPosition((char) ('a' + position.getColumn()), 8 - position.getRow() );
	}
	
	@Override
	public String toString() {
		return  "" + column + row;
	}
	
	
}
