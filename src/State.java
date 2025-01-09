abstract class State {
  protected PlayerTurn playerTurn;

  public void setPlayerTurn(PlayerTurn player) {
      this.playerTurn = player;
  }

  protected String player;

  protected int pieces;
  
  protected int turns;

  public State(String player, int pieces, int turns) {
    this.player = player;
    this.pieces = pieces;
    this.turns = turns;
  }

  public String getPlayer() {
    return player;
  };

  protected abstract void play();

  protected abstract void gameOver();

  protected abstract void endTurn();

  public void setState(State newState) {
    newState.setPlayerTurn(this.playerTurn);
    this.playerTurn.changeState();
  }
}
