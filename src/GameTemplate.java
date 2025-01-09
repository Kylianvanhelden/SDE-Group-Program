abstract class GameTemplate {
  protected abstract void initializeGame();

  protected abstract void playTurn();

  protected abstract boolean isGameOver();

  public final void playGame() {
    initializeGame();
    while (!isGameOver()) {
      playTurn();
    }
    if (CheckersGame.blackPieces < CheckersGame.whitePieces) {
      System.out.println("White has won, Game Over!");
    } else if (CheckersGame.whitePieces < CheckersGame.blackPieces) {
      System.out.println("Black has won, Game over");
    } else {
      System.out.println("Draw, Game Over!");
    }
  }
}