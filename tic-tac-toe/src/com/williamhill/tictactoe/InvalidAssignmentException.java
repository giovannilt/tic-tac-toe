package com.williamhill.tictactoe;

/**
 * Represents an invalid assignment on the board.
 * This exception should be thrown whenever a cell in 
 * the board is not free and a new sign is assigned on it
 * @author patrick_diloreto
 *
 */
public class InvalidAssignmentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3789499765568106061L;
	private final int row;
	private final int column;
	
	/**
	 * Represents an invalid assignment on the board.
	 * This exception should be thrown whenever a cell in 
	 * the board is not free and a new sign is assigned on it
	 * @param row value of the cell that caused the exception
	 * @param column value of the cell that caused the exception
	 */
	public InvalidAssignmentException(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * Represents an invalid assignment on the board.
	 * This exception should be thrown whenever a cell in 
	 * the board is not free and a new sign is assigned on it
	 * @param row value of the cell that caused the exception
	 * @param column value of the cell that caused the exception
	 * @param message the detail message. The detail message is saved 
	 * for later retrieval by the {@link #getMessage()} method.
	 */
	public InvalidAssignmentException(int row, int column, String message) {
		super(message);
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
