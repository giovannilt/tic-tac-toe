package com.williamhill.tictactoe;

/**
 * Tic Tac Toe board
 * @author patrick
 *
 */
public interface IBoard {

	/**
	 * This method return the sign of the cell at the row and column specified
	 * @param row Represents the cell row. Value should be between 1 and 3
	 * @param column Represents the cell column. Value should be between 1 and 3
	 * @return the sign associated to the specified Cell. It returns null if the cell has not been assigned yet
	 * @throws IllegalArgumentException This exception is thrown if the parameters are invalid
	 * @see Signs Signs Enum definiton for more information
	 */
	public Signs getCell(int row, int column) throws IllegalArgumentException;
	
	/**
	 * 
	 * This method assign a specific sign for the cell specified by its row and column value.
	 * @param row Represents the cell row. Value should be between 1 and 3
	 * @param column Represents the cell row. Value should be between 1 and 3
	 * @param sign Is the sign to associate with the current cell
	 * @throws InvalidAssignmentException This exception is thrown if the selected cell is not free and/or the current status is not Open (See {@link #getStatus()} for more details).
	 * @throws IllegalArgumentException This exception is thrown if the row and/or column value is invalid 
	 * (outside the bounds [1 - 3]) or the sign value is null
	 * @see Signs Signs Enum definiton for more information
	 * 
	 */
	public void setCell(int row, int column, Signs sign) throws InvalidAssignmentException, IllegalArgumentException;
	
	/**
	 * Return the board status.
	 * @return board status
	 * @see Status
	 */
	public Status getStatus();
	
	/**
	 * This method create a clone of the current board
	 * NOTE: the clone should produce a deep copy of the current object
	 * @return a clone of the current board
	 */
	public IBoard clone();
	
}
