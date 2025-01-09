abstract class GameTemplate {
  protected abstract void boardSize();

  protected abstract void initializeGame();

  protected abstract void playTurn();

  protected abstract boolean isGameOver();

  public final void playGame() {
    initializeGame();
    while (!isGameOver()) {
      playTurn();
    }
    System.out.println("Game Over!");
  }
}