import java.util.Scanner;

class CheckersGameSize8 extends GameTemplate {
  public static int size = 8;
  private final MoveProxy moveProxy = new MoveProxy(size);
  private final Board board = Board.getInstance(size); // Bord-instance ophalen
  private GameState currentState;
  private int turns = 5;

  @Override
  protected void initializeGame() {
    currentState = new PlayerTurnState("Black"); // Start met White
    System.out.println("Game initialized. Both sides have 10 moves");
    board.printBoard(); // Print het bord alleen hier bij start
  }

  @Override
  protected void playTurn() {
    currentState.play();

    Scanner scanner = new Scanner(System.in);
    System.out.println((turns / 2) + " turns left");
    System.out.println("Enter move (fromX fromY toX toY):");
    int fromX = scanner.nextInt();
    int fromY = scanner.nextInt();
    int toX = scanner.nextInt();
    int toY = scanner.nextInt();

    // Pass currentState to moveProxy.makeMove
    if (moveProxy.makeMove(fromX, fromY, toX, toY, currentState)) {
      board.printBoard(); // Alleen printen bij een geldige zet

      if (currentState instanceof PlayerTurnState) {
        String currentPlayer = ((PlayerTurnState) currentState).getPlayer();
        currentState = currentPlayer.equals("White")
            ? new PlayerTurnState("Black") // Wissel naar Black
            : new PlayerTurnState("White"); // Wissel naar White
      }
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

  public static int boardSize() {
    return size;
  }
}
