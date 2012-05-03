package com.williamhill.tictactoe;

/**
 * Board Status
 * @author patrick
 *
 */
public enum Status {

	/**
	 * Game is running
	 */
	GameOpen,
	/**
	 * Game Over with Cross Player Winner
	 */
	CrossWin,
	/**
	 * Game Over with Circle Player Winner
	 */
	CircleWin,
	/**
	 * Game Over in a Draw
	 */
	Draw
}
