package com.williamhill.tictactoe;

/**
 * Contains the information for the Player move
 * @author patrick
 *
 */
public class Move {

	private final int row;
	private final int column;
	
	public Move(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	
}
