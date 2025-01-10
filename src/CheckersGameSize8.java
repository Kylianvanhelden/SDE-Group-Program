import java.util.Scanner;

class CheckersGameSize8 extends GameTemplate {
  public static int size = 8;
  private int turns = 20;
  private final MoveProxy moveProxy = new MoveProxy(size);
  private final Board board = Board.getInstance(size); // Bord-instance ophalen
  private State currentPlayer = new BlackPlays();
  private PlayerTurn playerTurn = new PlayerTurn(currentPlayer);
  

  @Override
  protected void initializeGame() {
    currentPlayer.setPlayerTurn(playerTurn);
    System.out.println("Game initialized. Both sides have 10 moves");
    board.printBoard(); // Print het bord alleen hier bij start
    System.out.println(playerTurn + " is the state");
  }

  @Override
  protected void playTurn() {
    playerTurn.play();

    Scanner scanner = new Scanner(System.in);
    System.out.println(((turns + 1) / 2) + " turns left");
    System.out.println("Enter move (fromX fromY toX toY):");
    int fromX = scanner.nextInt();
    int fromY = scanner.nextInt();
    int toX = scanner.nextInt();
    int toY = scanner.nextInt();

    // Pass currentState to moveProxy.makeMove
    if (moveProxy.makeMove(fromX, fromY, toX, toY, playerTurn.getState())) {
      board.printBoard(); // Alleen printen bij een geldige zet

      playerTurn.endTurn();
      turns--;
    } else {
      System.out.println("Invalid move. Try again.");
    }
  }

  @Override
  protected boolean isGameOver() {
    // Simple game-over condition (can be expanded)
    if (turns <= 0) {
      return true;
    }
    return false;
  }

  protected void endGame() {
    if (CheckersGame.whitePieces < CheckersGame.blackPieces) {
      if (turns % 2 == 1) {
        playerTurn.endTurn();
      }
      playerTurn.gameOver();
    } else if (CheckersGame.blackPieces < CheckersGame.whitePieces) {
      if (turns % 2 == 0) {
        playerTurn.endTurn();
      }
      playerTurn.gameOver();
    } else {
      System.out.println("Game over!");
    }
  }

  public static int boardSize() {
    return size;
  }
}
