package com.williamhill.tictactoe;

public enum Signs {

	Cross('X'),
	Circle('O');
	
	private char sign;
	
	public char getSignString() {
		return sign;
	}
	
	private Signs(char sign) {
		this.sign = sign;
	}
}
