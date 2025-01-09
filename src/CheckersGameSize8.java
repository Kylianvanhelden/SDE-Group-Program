import java.util.Scanner;

class CheckersGameSize8 extends GameTemplate {
  public static int size = 8;
  private int turns = 20;
  private final MoveProxy moveProxy = new MoveProxy(size);
  private final Board board = Board.getInstance(size); // Bord-instance ophalen
  private State currentPlayer = new BlackPlays(((size / 2) - 1), (turns));
  private PlayerTurn playerTurn;

  @Override
  protected void initializeGame() {
    playerTurn = new PlayerTurn(currentPlayer);
    System.out.println("Game initialized. Both sides have 10 moves");
    board.printBoard(); // Print het bord alleen hier bij start
    System.out.println(playerTurn + " is the state");
  }

  @Override
  protected void playTurn() {
    playerTurn.play();

    Scanner scanner = new Scanner(System.in);
    System.out.println((turns / 2) + " turns left");
    System.out.println("Enter move (fromX fromY toX toY):");
    int fromX = scanner.nextInt();
    int fromY = scanner.nextInt();
    int toX = scanner.nextInt();
    int toY = scanner.nextInt();

    // Pass currentState to moveProxy.makeMove
    if (moveProxy.makeMove(fromX, fromY, toX, toY, playerTurn.getState())) {
      board.printBoard(); // Alleen printen bij een geldige zet

      playerTurn.changeState();
      turns--;
    } else {
      System.out.println("Invalid move. Try again.");
    }
    System.out.println(playerTurn.getState() + " is the state");
  }

  @Override
  protected boolean isGameOver() {
    // Simple game-over condition (can be expanded)
    if (turns <= 0) {
        return true;
    }
    return false;
  }

  public static int boardSize() {
    return size;
  }
}
