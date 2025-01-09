import java.util.Scanner;

class CheckersGame extends GameTemplate {
  public static int size = 10;
  private final MoveProxy moveProxy = new MoveProxy(size);
  private final Board board = Board.getInstance(size); // Bord-instance ophalen
  private PlayerTurn playerTurn;
  public static int whitePieces = ((size / 2) * ((size / 2) - 1));
  public static int blackPieces = ((size / 2) * ((size / 2) - 1));

  @Override
  protected void initializeGame() {
    playerTurn = new PlayerTurn(new WhitePlays(20, 10)); // Start met White
    System.out.println("Game initialized.");
    board.printBoard(); // Print het bord alleen hier bij start
  }

  @Override
  protected void playTurn() {
    playerTurn.play();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter move (fromX fromY toX toY):");
    int fromX = scanner.nextInt();
    int fromY = scanner.nextInt();
    int toX = scanner.nextInt();
    int toY = scanner.nextInt();

    // Pass currentState to moveProxy.makeMove
    if (moveProxy.makeMove(fromX, fromY, toX, toY, playerTurn.getState())) {
      board.printBoard(); // Alleen printen bij een geldige zet

      playerTurn.endTurn();
    } else {
      System.out.println("Invalid move. Try again.");
    }
  }

  @Override
  protected boolean isGameOver() {
    //state opvragen inplaats van boolean
    if (whitePieces == 0 || blackPieces == 0) {
      return true;
    }
    return false;
  }

  public static int boardSize() {
    return size;
  }
}
