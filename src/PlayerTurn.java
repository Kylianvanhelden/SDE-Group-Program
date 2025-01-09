class PlayerTurn {

  private State state;

  public PlayerTurn(State beginState) {
    this.state = beginState;
  }

  public State getState() {
    return state;
  }

  public void changeState() {
    this.state.endTurn();
  }

  public void play() {
    this.state.play();
  }

  public void gameOver() {
    throw new UnsupportedOperationException("Unimplemented method 'gameOver'");
  }
}
