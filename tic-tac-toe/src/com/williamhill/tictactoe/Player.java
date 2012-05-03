package com.williamhill.tictactoe;

/**
 * Represents a Player in the Game
 * @author patrick
 *
 */
public abstract class Player {

	private String name;
	private Signs sign;
	
	
	public Signs getSign() {
		return sign;
	}

	public void setSign(Signs sign) {
		this.sign = sign;
	}

	public Player(String name, Signs sign) {
		this.name = name;
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method should return the next move for this player.
	 * @param board the input argument is the board that can be used to explore the different scenarios depending on the next move. 
	 * Changes on this object will not be reflect on the game, only the returned Move object will be considered as valid move.
	 * @return the move this player wants to make.
	 */
	public abstract Move getNextMove(IBoard board);


}
