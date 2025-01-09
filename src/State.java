abstract class State {
  protected PlayerTurn playerTurn;

  public void setPlayerTurn(PlayerTurn player) {
      this.playerTurn = player;
  }

  protected String name;

  protected int pieces;
  
  protected int turns;

  public State(String name, int pieces, int turns) {
    this.name = name;
    this.pieces = pieces;
    this.turns = turns;
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
