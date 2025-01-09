abstract class GameTemplate {
  protected abstract void initializeGame();

  protected abstract void playTurn();

  protected abstract boolean isGameOver();

  protected abstract void endGame();

  public final void playGame() {
    initializeGame();
    while (!isGameOver()) {
      playTurn();
    }
    endGame();
  }
}