package com.williamhill.tictactoe;

import com.williamhill.tictactoe.impl.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Is the controller for Tic Tac Toe Game
 *
 * @author patrick
 */
public class Game {

    private static final String DEFAULT_USER_PLAYER_CLASS = "com.williamhill.tictactoe.player.UserPlayer";

    private static final String DEFAULT_AI_PLAYER_CLASS = "a.a.a.a.b";//com.williamhill.tictactoe.ai.AIPlayer

    private Player p1;
    private Player p2;

    private IBoard board;

    private Player currentPlayer;

    private BoardConsoleDisplay display;

    public void start(Player p1, Player p2) throws IOException {
        this.p1 = p1;
        this.p2 = p2;
        board = createNewBoard();
        display = new BoardConsoleDisplay(board);
        currentPlayer = p1;
        displayHelp();
        System.out.println("\nPress Enter [Return] button to continue");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        r.readLine();
        go();
    }

    /**
     * Create here a new instance of your board implementation
     *
     * @return tic tac toe board
     */
    protected IBoard createNewBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public void go() {
        display.display();
        if (isGameEnded()) {
            System.out.println("Game Ended result: " + board.getStatus());
            return;
        }
        System.out.println("Player " + currentPlayer.getName() + " moves.");
        Move move = currentPlayer.getNextMove(board.clone());
        try {
            board.setCell(move.getRow(), move.getColumn(), currentPlayer.getSign());
        } catch (InvalidAssignmentException e) {
            throw new RuntimeException(e);
        }
        currentPlayer = (currentPlayer == p1 ? p2 : p1);
        go();
    }

    /**
     * Implements the game ended status here
     *
     * @return true if the game is over
     */
    private boolean isGameEnded() {
        return board.getStatus() != Status.GameOpen || board.getStatus()== Status.Draw;
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        String player2Start = System.getProperty("tris.player2.start", "false");
        String player1Name = System.getProperty("tris.player1.name", "Player1");
        String player2Name = System.getProperty("tris.player2.name", "Player2");

        String player1ClassName = System.getProperty("tris.player1.class", DEFAULT_USER_PLAYER_CLASS);
        String player2ClassName = System.getProperty("tris.player2.class", DEFAULT_AI_PLAYER_CLASS);

        @SuppressWarnings("unchecked")
        Class<Player> player1Class = (Class<Player>) Class.forName(player1ClassName);
        @SuppressWarnings("unchecked")
        Class<Player> player2Class = (Class<Player>) Class.forName(player2ClassName);

        Player player1 = player1Class.getConstructor(String.class, Signs.class).newInstance(player1Name, Signs.Cross);
        Player player2 = player2Class.getConstructor(String.class, Signs.class).newInstance(player2Name, Signs.Circle);

        if ("false".equals(player2Start)) {
            game.start(player1, player2);
        } else {
            game.start(player2, player1);
        }

    }

    public void displayHelp() {
        System.out.println("\n ===== TRIS GAME [HELP] =====\n\n");

        System.out.println("[1,1] | [1,2] | [1,3]");
        System.out.println("---------------------");
        System.out.println("[2,1] | [2,2] | [2,3]");
        System.out.println("---------------------");
        System.out.println("[3,1] | [3,2] | [3,3]");

    }
}
