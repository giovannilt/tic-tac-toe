######################################################################
##  WH Questions - v1.00
######################################################################

Thank you for your interest in working with William Hill.

We are passionate about the work we do and have built a reputation on 
the high quality of our thinking, our delivery and client satisfaction. 

We are looking to recruit brilliant individuals who are highly skilled 
and highly motivated to work with us to continue to achieve this.

You should find the following files in this archive :

./lib/ticTacToeAI.jar
./src/com/williamhill/tictactoe/BoardConsoleDisplay.java
./src/com/williamhill/tictactoe/Game.java
./src/com/williamhill/tictactoe/IBoard.java
./src/com/williamhill/tictactoe/InvalidAssignmentException.java
./src/com/williamhill/tictactoe/Move.java
./src/com/williamhill/tictactoe/Player.java
./src/com/williamhill/tictactoe/Signs.java
./src/com/williamhill/tictactoe/Status.java

We have put together a number of questions based around these files 
in order to give us a basic understanding of your skills.

1. Implements IBoard interface in order to produce a board class consistent with the game
2. Create a UserPlayer class which can be used by a human player to play against the AI player
3. Implements the Game.isGameEnded() and Game.createNewBoard() methods.
4. Run successfully the application with no exceptions (see HOW TO RUN)
5. Write some tests to make sure we are covering the happy paths and some basic error conditions
6. Automate build/test with a tool of your preference
7. (Optional) Write an AIPlayer for Player1 which doesn't loose against the AIPlayer for Player2

NOTE: 
1. Make sure to respect the contract definition of the interfaces.
2. Do not modify the classes which are not required.



=============== HOW TO RUN ====================

java -Dtris.player1.class=<full name of the class which implements IPlayer>  -classpath lib/ticTacToeAI.jar com.williamhill.tictactoe.Game

===============================================

