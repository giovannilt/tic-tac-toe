package com.williamhill.tictactoe;

/**
 * Print in the console the board status representation
 * @author patrick
 *
 */
public class BoardConsoleDisplay {

	private IBoard board;
	
	public BoardConsoleDisplay(IBoard board) {
		this.board = board;
	}
	
	public void display() {
		StringBuilder buffer = new StringBuilder("\n ===== TRIS GAME =====\n\n");
		if(board != null) {
			for(int row=1; row<=3; row++) {
				for(int column=1; column<=3; column++) {
					Signs cell = board.getCell(row, column);
					if(cell == Signs.Circle) {
						buffer.append(" O ");
					}
					else if(cell == Signs.Cross) {
						buffer.append(" X ");
					}
					else { //is null
						buffer.append("   ");
					}
					if(column < 3)
						buffer.append("|");
				}
				buffer.append("\n");

				if(row < 3)
					buffer.append("------------\n");
			}
		}
		
		System.out.println(buffer.toString());
	}
	
}
