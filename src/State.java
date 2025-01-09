abstract class State {
  protected PlayerTurn playerTurn;

  public void setPlayerTurn(PlayerTurn player) {
      this.playerTurn = player;
  }

  protected String name;

  public State(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  };

  protected abstract void play();

  protected abstract void gameOver();

  protected abstract void endTurn();

  public void setState(State newState) {
    newState.setPlayerTurn(this.playerTurn);
    this.playerTurn.changeState(newState);
  }
}
