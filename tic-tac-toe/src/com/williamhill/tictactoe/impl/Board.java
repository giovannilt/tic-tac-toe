package com.williamhill.tictactoe.impl;

import com.williamhill.tictactoe.IBoard;
import com.williamhill.tictactoe.InvalidAssignmentException;
import com.williamhill.tictactoe.Signs;
import com.williamhill.tictactoe.Status;

/**
 * Created with IntelliJ IDEA.
 * User: latorgi
 * Date: 26/04/12
 * Time: 17:00
 */
public class Board implements IBoard {

    private Signs[][] board;

    public Board() {
        board = new Signs[3][3];
    }

    private Board(Signs[][] board) {
        this.board = board;
    }

    public Signs getCell(int row, int column) throws IllegalArgumentException {
        check(row);
        check(column);
        return board[row - 1][column - 1];
    }

    private void setCell(Signs sign, int row, int column) throws InvalidAssignmentException, IllegalArgumentException {
        Signs point = getCell(row, column);
        if (point == null) {
            board[row - 1][column - 1] = sign;

        } else {
            throw new InvalidAssignmentException(row, column);
        }
    }

    public void setCell(int row, int column, Signs sign) throws InvalidAssignmentException, IllegalArgumentException {
        setCell(sign, row, column);
    }

    public Status getStatus() {
        if (isDraw()) {
            return Status.Draw;
        } else {
            Signs theWinner = null;
            //horizontal
            if (isNotNull(getCell(1, 1)) && isNotNull(getCell(1, 2)) && isNotNull(getCell(1, 3))
                    && getCell(1, 1).getSignString() == getCell(1, 2).getSignString() && getCell(1, 2).getSignString() == getCell(1, 3).getSignString()) {
                theWinner = getCell(1, 1);
            }
            if (isNotNull(getCell(2, 1)) && isNotNull(getCell(2, 2)) && isNotNull(getCell(2, 3))
                    && getCell(2, 1).getSignString() == getCell(2, 2).getSignString() && getCell(2, 2).getSignString() == getCell(2, 3).getSignString()) {
                theWinner = getCell(2, 1);
            }
            if (isNotNull(getCell(3, 1)) && isNotNull(getCell(3, 2)) && isNotNull(getCell(3, 3)) &&
                    getCell(3, 1).getSignString() == getCell(3, 2).getSignString() && getCell(3, 2).getSignString() == getCell(3, 3).getSignString()) {
                theWinner = getCell(3, 1);
            }
            //virticle wins
            if (isNotNull(getCell(1, 1)) && isNotNull(getCell(2, 1)) && isNotNull(getCell(3, 1)) &&
                    getCell(1, 1).getSignString() == getCell(2, 1).getSignString() && getCell(2, 1).getSignString() == getCell(3, 1).getSignString()) {
                theWinner = getCell(1, 1);
            }
            if (isNotNull(getCell(1, 2)) && isNotNull(getCell(2, 2)) && isNotNull(getCell(3, 2)) &&
                    getCell(1, 2).getSignString() == getCell(2, 2).getSignString() && getCell(2, 2).getSignString() == getCell(3, 2).getSignString()) {
                theWinner = getCell(1, 2);
            }
            if (isNotNull(getCell(1, 3)) && isNotNull(getCell(2, 3)) && isNotNull(getCell(3, 3)) &&
                    getCell(1, 3).getSignString() == getCell(2, 3).getSignString() && getCell(2, 3).getSignString() == getCell(3, 3).getSignString()) {
                theWinner = getCell(1, 3);
            }
            //diagonal wins
            if (isNotNull(getCell(1, 1)) && isNotNull(getCell(2, 2)) && isNotNull(getCell(3, 3)) &&
                    getCell(1, 1).getSignString() == getCell(2, 2).getSignString() && getCell(2, 2).getSignString() == getCell(3, 3).getSignString()) {
                theWinner = getCell(1, 1);
            }
            if (isNotNull(getCell(1, 3)) && isNotNull(getCell(2, 2)) && isNotNull(getCell(3, 1)) &&
                    getCell(1, 3).getSignString() == getCell(2, 2).getSignString() && getCell(2, 2).getSignString() == getCell(3, 1).getSignString()) {
                theWinner = getCell(1, 3);
            }
            if (theWinner == null) {
                return Status.GameOpen;
            } else {
                return theWinner == Signs.Circle ? Status.CircleWin : Status.CrossWin;
            }
        }
    }

    public IBoard clone() {
        Signs[][] b = new Signs[3][3];
        for (int row = 0; row <= 2; row++) {
            for (int column = 0; column <= 2; column++) {
                b[row][column] = isNotNull(board[row][column]) ? board[row][column] == Signs.Cross ? Signs.Cross : Signs.Circle : null;
            }
        }
        return new Board(b);
    }

    private void check(int num) throws IllegalArgumentException {
        if (num < 1 || num > 3) {
            System.out.println(num);
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNull(Signs s) {
        return s != null;
    }

    private boolean isDraw() {
        int valNotNull = 0;
        for (int row = 0; row <= 2; row++) {
            for (int column = 0; column <= 2; column++) {
                if (isNotNull(board[row][column]))
                    valNotNull++;
            }
        }
        return valNotNull == 9;
    }

}
