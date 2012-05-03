package com.williamhill.tictactoe.impl;

import com.williamhill.tictactoe.IBoard;
import com.williamhill.tictactoe.Move;
import com.williamhill.tictactoe.Player;
import com.williamhill.tictactoe.Signs;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: latorgi
 * Date: 26/04/12
 * Time: 18:09
 */
public class UserPlayer extends Player {
    private Scanner input = new Scanner(System.in);

    public UserPlayer(String name, Signs sign) {
        super(name, sign);
    }

    @Override
    public Move getNextMove(IBoard board) {


        System.out.print("Enter ROW: ");
        int row = getInputFromConsole();

        System.out.print("Enter COLUMN: ");
        int column = getInputFromConsole();


        return new Move(row, column);
    }

    private int getInputFromConsole() {
        while (input.hasNext()) {
            try {
                return new Integer(input.next()).intValue();
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number please give me a number between 1 and 3.");
            }
        }
        return -500;
    }
}