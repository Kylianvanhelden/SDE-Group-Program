class PlayerTurn {

  private State state;

  public PlayerTurn(State beginState) {
    this.state = beginState;
  }

  public State getState() {
    return state;
  }

  public void endTurn() {
    this.state.endTurn();
  }

  public void play() {
    //System.out.println(player + "'s turn.");
  }

  public void gameOver() {
    throw new UnsupportedOperationException("Unimplemented method 'gameOver'");
  }
}
